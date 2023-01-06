package contocorrente.conto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.conto.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation,Integer> {
    
}
