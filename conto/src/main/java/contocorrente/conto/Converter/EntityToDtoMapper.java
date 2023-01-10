package contocorrente.conto.Converter;

import java.util.List;

import javax.transaction.Transactional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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

     @Mapping(target = "userDto" , source = "user")
     @Mapping(target = "operationDto" , source = "operation")
     ContoDto contoToContoDto(Conto conto);

     @Mapping(target = "userDto" , source = "user")
     @Mapping(target = "operationDto" , source = "operation")
     ContoBancaDto contoBancaToContoBancaDto(ContoBanca contoBanca);

     @Mapping(target = "userDto" , source = "user")
     @Mapping(target = "operationDto" , source = "operation")
     ContoPaypalDto contoPaypalToContoPaypalDto(ContoPaypal contoPaypal);

     @Mapping(target = "userDto" , source = "user")
     @Mapping(target = "operationDto" , source = "operation")
     ContoBorsellinoDto contoBorsellinoToContoBorsellinoDto(ContoBorsellino contoBorsellino);

     @Mapping(target = "user" , source = "userDto")
     @Mapping(target = "operation" , source = "operationDto")
     Conto contoDtoToConto(ContoDto contoDto);
     
     @Mapping(target = "user" , source = "userDto")
     @Mapping(target = "operation" , source = "operationDto")
     ContoBanca contoBancaDtoToContoBanca(ContoBancaDto contoBancaDto);

     @Mapping(target = "user" , source = "userDto")
     @Mapping(target = "operation" , source = "operationDto")
     ContoPaypal contoPaypaDtolToContoPaypal(ContoPaypalDto contoPaypalDto);

     @Mapping(target = "user" , source = "userDto")
     @Mapping(target = "operation" , source = "operationDto")
     ContoBorsellino contoBorsellinoDtoToContoBorsellino(ContoBorsellinoDto contoBorsellinoDto);

     @Mapping(target = "operation" , ignore = true)
     List<ContoDto> allContoEntitiesToContoDto (List<Conto> lista);

     List<Conto> allContoDtoToContoEntities (List<ContoDto> lista);

     //////////////////////////////////////////////////////
     // @Mapping(target = "contoDto" , source = "conto")
     OperationDto operationToOperationDto (Operation operation);

     @Mapping(target = "conto" , source = "contoDto")
     Operation operationDtoToOperation (OperationDto operationDto);

     List<OperationDto> allOperationEntitiesToOperationDto (List<Operation> lista);

     List<Operation> allOperationDtoToOperationEntities (List<OperationDto> lista);




}