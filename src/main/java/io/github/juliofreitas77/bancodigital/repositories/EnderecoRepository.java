package io.github.juliofreitas77.bancodigital.repositories;

import io.github.juliofreitas77.bancodigital.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    @Transactional
    Endereco findByClienteId(Integer idCliente);
}
