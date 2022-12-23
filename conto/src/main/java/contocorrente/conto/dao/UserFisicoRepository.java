package contocorrente.conto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.conto.entities.UserFisico;

public interface UserFisicoRepository extends JpaRepository<UserFisico,Integer >{
    
}
