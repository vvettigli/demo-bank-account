package contocorrente.conto.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.conto.entities.ContoBanca;

public interface ContoBancaRepository extends JpaRepository<ContoBanca,Integer> {

     
}
