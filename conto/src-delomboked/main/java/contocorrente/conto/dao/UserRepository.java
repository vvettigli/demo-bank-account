package contocorrente.conto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contocorrente.conto.entities.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    
}
