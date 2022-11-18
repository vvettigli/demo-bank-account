package contocorrente.conto.services;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.dao.ContoRepository;
import contocorrente.entities.Conto;

@Service
public class ContoService {

    @Autowired
    ContoRepository contoRepository;

    public Conto addConto(Conto conto){
        return contoRepository.save(conto);
    }

    public List<Conto> getAllConto(){

        List<Conto> conti= new ArrayList<Conto>();
        contoRepository.findAll().forEach(conti::add);
        return conti;

    }
    public Conto getConto(String Userid){
        return contoRepository.findByUserID(Userid);
    }

    public Conto updateConto(int id, Conto conto){
        return contoRepository.save(conto);
    }
    public void deleteContoById(String id){
        contoRepository.deleteById(id);
    }
    
}
