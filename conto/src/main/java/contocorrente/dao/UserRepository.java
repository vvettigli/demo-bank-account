package contocorrente.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contocorrente.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    
    
}
