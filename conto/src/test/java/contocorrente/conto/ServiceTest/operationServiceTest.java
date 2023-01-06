package contocorrente.conto.ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import contocorrente.conto.Converter.EntityToDtoMapper;
import contocorrente.conto.entities.Operation;
import contocorrente.conto.services.OperationService;

@SpringBootTest
public class operationServiceTest {
    
    @Autowired
    OperationService operationService;
    @Autowired
    EntityToDtoMapper converter;


    @Test 
    void givenOperationShouldAddOperationInAnConto(){
        
        //give 
        Operation operation = Operation.builder().build();
        
        
    }
}
