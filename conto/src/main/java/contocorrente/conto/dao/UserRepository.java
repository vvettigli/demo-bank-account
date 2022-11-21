package contocorrente.conto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contocorrente.conto.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // public User findByUserID(Integer userID);
    
}
