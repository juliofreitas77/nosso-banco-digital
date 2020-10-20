package io.github.juliofreitas77.bancodigital.services;

import io.github.juliofreitas77.bancodigital.domain.Cliente;
import io.github.juliofreitas77.bancodigital.dto.ClienteDTO;
import io.github.juliofreitas77.bancodigital.repositories.ClienteRepository;
import io.github.juliofreitas77.bancodigital.services.exceptions.ClienteDuplicadoException;
import io.github.juliofreitas77.bancodigital.services.exceptions.OlderAgeException;
import io.github.juliofreitas77.bancodigital.services.exceptions.ValidaPropostaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    //List<FieldMessage> lista = new ArrayList<>();
    public List<Cliente> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Cliente insert(Cliente obj) {
        Cliente cli = repository.findByCpf(obj.getCpf());
        Cliente cli2 = repository.findByEmail(obj.getEmail());
        if (cli != null || cli2 != null) {
            //lista.add(new FieldMessage("cpf", "CPF existente na base"));
            throw new ClienteDuplicadoException("Dados já existes na base: CPF: " + obj.getCpf()
            +" Email: " + obj.getEmail());
        }
        else {
            int idadeCliente = Period.between(obj.getDataNascimento(), LocalDate.now()).getYears();
            if (idadeCliente >= 18) {
                obj.setId(null);
                return repository.save(obj);
            } else {
                throw new OlderAgeException("Cliente menor: " + idadeCliente + " anos de idade. Proposta recusada");
            }
        }
    }

    public Cliente fromDTO(ClienteDTO dto) {
        return new Cliente(dto.getName(), dto.getSobreNome(), dto.getEmail(), dto.getDataNascimento(),
                dto.getCpf());
    }

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ValidaPropostaException("Objeto não encontrado: " + id
                + ", Tipo: " + Cliente.class.getName()));
    }
}
