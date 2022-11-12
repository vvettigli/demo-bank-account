package conto_corrente.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import conto_corrente.Entity.user;
@Repository
public interface userDao extends JpaRepository<user,String> {
    
    
}
