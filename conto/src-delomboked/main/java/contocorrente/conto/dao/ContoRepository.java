package contocorrente.conto.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.conto.entities.Conto;

public interface ContoRepository extends JpaRepository<Conto,Integer> {

     
}
