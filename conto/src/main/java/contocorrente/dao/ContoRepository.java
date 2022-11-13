package contocorrente.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.entities.Conto;

public interface ContoRepository extends JpaRepository<Conto,String> {
     Conto findByUserID(String userID);
}
