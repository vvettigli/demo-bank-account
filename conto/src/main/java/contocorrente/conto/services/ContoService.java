package contocorrente.conto.services;

import java.util.List;

import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.entities.Conto;

public interface ContoService {

    public ContoDto addConto(Conto conto);

    public List<ContoDto> getAllConti();
    
    public ContoDto getConto(Integer id);
    
    public ContoDto updateConto(ContoDto contoDtoUpdate);
        
    public void deleteConto(Integer id);
    
}
