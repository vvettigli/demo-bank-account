package contocorrente.conto.Converter;

import java.util.List;

import org.mapstruct.Mapper;


import contocorrente.conto.dto.ContoBancaDto;
import contocorrente.conto.dto.ContoBorsellinoDto;
import contocorrente.conto.dto.ContoDto;
import contocorrente.conto.dto.ContoPaypalDto;
import contocorrente.conto.dto.OperationDto;
import contocorrente.conto.dto.UserDto;
import contocorrente.conto.dto.UserFisicoDto;
import contocorrente.conto.dto.UserGiuridicoDto;
import contocorrente.conto.entities.Conto;
import contocorrente.conto.entities.ContoBanca;
import contocorrente.conto.entities.ContoBorsellino;
import contocorrente.conto.entities.ContoPaypal;
import contocorrente.conto.entities.Operation;
import contocorrente.conto.entities.UserFisico;
import contocorrente.conto.entities.UserGiuridico;
import contocorrente.conto.entities.Users;

@Mapper(componentModel = "spring")
public interface EntityToDtoMapper {


    
     UserDto userToUserDto(Users user);

     UserFisicoDto userFisicoToUserFisicoDto(UserFisico userFisico);

     UserGiuridicoDto userGiuridicoToUserGiuridicoDto(UserGiuridico userGiuridico);

     Users userDtoToUser(UserDto userDto);

     UserFisico userFisicoDtoToUserFisico(UserFisicoDto userDto);

     UserGiuridico userGiuridicoDtoToUserGiuridico(UserGiuridicoDto userDto);

     List<UserDto> allUsersEntitiesToUsersDto (List<Users> lista);

     List<Users> allUsersDtoToUsersEntities (List<UserDto> lista);

     //////////////////////////////////////////////////////

     ContoDto contoToContoDto(Conto conto);

     ContoBancaDto contoBancaToContoBancaDto(ContoBanca contoBanca);

     ContoPaypalDto contoPaypalToContoPaypalDto(ContoPaypal contoPaypal);

     ContoBorsellinoDto contoBorsellinoToContoBorsellinoDto(ContoBorsellino contoBorsellino);

     Conto contoDtoToConto(ContoDto contoDto);

     ContoBanca contoBancaDtoToContoBanca(ContoBancaDto contoBancaDto);

     ContoPaypal contoPaypaDtolToContoPaypal(ContoPaypalDto contoPaypalDto);

     ContoBorsellino contoBorsellinoDtoToContoBorsellino(ContoBorsellinoDto contoBorsellinoDto);

     List<ContoDto> allContoEntitiesToContoDto (List<Conto> lista);

     List<Conto> allContoDtoToContoEntities (List<ContoDto> lista);

     //////////////////////////////////////////////////////

     OperationDto operationToOperationDto (Operation operation);

     Operation operationDtoToOperation (OperationDto operationDto);

     List<OperationDto> allOperationEntitiesToOperationDto (List<Operation> lista);

     List<Operation> allOperationDtoToOperationEntities (List<OperationDto> lista);




}