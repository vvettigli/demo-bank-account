package contocorrente.conto.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.entities.Conto;
@Component
public class ContoConverter {
    public ContoDto entityToDto(Conto conto){

        ContoDto dto = new ContoDto();
        dto.setId(conto.getId());
        dto.setUser(conto.getUser());
        dto.setSaldo(conto.getSaldo());
        dto.setOperation(conto.getOperation());
        return dto;

    }

    public Conto dtoToEntity(ContoDto dto){

        Conto conto = new Conto();
        conto.setId(dto.getId());
        conto.setUser(dto.getUser());
        conto.setSaldo(dto.getSaldo());
        conto.setOperation(dto.getOperation());
        return conto;
    }

    public List<ContoDto> allEntityToDto(List<Conto> conto){
        return conto.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<Conto> allDtoToEntity(List<ContoDto> ContoDto){
        return ContoDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
