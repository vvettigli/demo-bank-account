package contocorrente.conto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contocorrente.dao.OperationRepository;
import contocorrente.entities.Operation;
@Service
public class OperationService {
    @Autowired
    OperationRepository operationRepository;

    public Operation addOperation(Operation conto){
        return operationRepository.save(conto);
    }

    public List<Operation> getAllOperations(){

        List<Operation> conti= new ArrayList<Operation>();
        operationRepository.findAll().forEach(conti::add);
        return conti;

    }
    public Operation getOperation(String id){
        return operationRepository.getById(id);
    }

    public Operation updateOperation(int id, Operation conto){
        return operationRepository.save(conto);
    }
    public void deleteOperationById(String id){
        operationRepository.deleteById(id);
    }
    
}
