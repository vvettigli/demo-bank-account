package contocorrente.conto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import contocorrente.conto.entities.UserGiuridico;

public interface UserGiuridicoRepository extends JpaRepository<UserGiuridico, Integer> {
    
}
