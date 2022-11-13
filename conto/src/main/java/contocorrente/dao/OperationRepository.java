package contocorrente.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation,String> {
    
}
