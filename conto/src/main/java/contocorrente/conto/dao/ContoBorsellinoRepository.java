package contocorrente.conto.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.conto.entities.ContoBorsellino;

public interface ContoBorsellinoRepository extends JpaRepository<ContoBorsellino,Integer> {

     
}
