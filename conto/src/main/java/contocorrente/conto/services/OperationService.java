package contocorrente.conto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.conto.dao.OperationRepository;
import contocorrente.conto.entities.Operation;
@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;

    public Operation addOperation(Operation operation){
        return operationRepository.save(operation);
    }

    public List<Operation> getAllOperations(){
        return operationRepository.findAll();
        

    }
    public Operation getOperation(Integer id){
        return operationRepository.getById(id);
    }

    public Operation updateOperation(int id, Operation operation){
        return operationRepository.save(operation);
    }
    public void deleteOperationById(Integer id){
        operationRepository.deleteById(id);
    }
    
}
