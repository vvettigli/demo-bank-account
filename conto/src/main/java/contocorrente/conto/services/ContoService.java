package contocorrente.conto.services;

import java.util.List;

import contocorrente.conto.dto.ContoBancaDto;
import contocorrente.conto.dto.ContoBorsellinoDto;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.ContoPaypalDto;

public interface ContoService {

    public ContoDto addConto(ContoDto contoDto);

    public ContoBancaDto addConto(ContoBancaDto contoBancaDto);

    public ContoBorsellinoDto addConto(ContoBorsellinoDto contoBorsellinoDto);

    public ContoPaypalDto addConto(ContoPaypalDto contoPaypalDto);
    
    public <T extends ContoDto> T getConto(Integer id);

    public List<ContoDto> getAllConti();
    
    public ContoDto updateConto(ContoDto contoDtoUpdate);

    public ContoBancaDto updateConto(ContoBancaDto contoBancaDtoUpdate);

    public ContoBorsellinoDto updateConto(ContoBorsellinoDto contoBorsellinoDtoUpdate);

    public ContoPaypalDto updateConto(ContoPaypalDto contoPaypalDtoUpdate);

    public <T extends ContoDto>void deleteConto(Integer id);
    
}
