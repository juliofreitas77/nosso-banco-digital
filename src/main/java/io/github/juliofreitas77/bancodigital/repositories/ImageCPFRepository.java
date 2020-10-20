package io.github.juliofreitas77.bancodigital.repositories;

import io.github.juliofreitas77.bancodigital.domain.ImageCPF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageCPFRepository extends JpaRepository<ImageCPF, Integer> {
    Optional<ImageCPF> findByCliente_Id(Integer cliente_id);

}
