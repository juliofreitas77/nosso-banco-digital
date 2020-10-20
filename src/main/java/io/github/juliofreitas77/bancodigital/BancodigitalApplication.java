package io.github.juliofreitas77.bancodigital;

import io.github.juliofreitas77.bancodigital.domain.Cliente;
import io.github.juliofreitas77.bancodigital.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@SpringBootApplication
public class BancodigitalApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(BancodigitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente("Julio Cesar", "Silva de Freitas", "julio@gmail.com", LocalDate.of(1988, Month.JUNE, 13), "011.111.222-55");
        Cliente c2 = new Cliente("Mara", "Rodovalhor Ribeiro", "tata@gmail.com", LocalDate.of(1977, Month.APRIL, 11), "015.152.155-47");

        clienteRepository.saveAll(Arrays.asList(c1, c2));
    }
}
