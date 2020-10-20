package io.github.juliofreitas77.bancodigital.repositories;

import io.github.juliofreitas77.bancodigital.domain.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

}
