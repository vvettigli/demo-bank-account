package contocorrente.conto.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.conto.entities.ContoPaypal;

public interface ContoPaypalRepository extends JpaRepository<ContoPaypal,Integer> {

     
}
