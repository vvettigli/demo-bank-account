package contocorrente.conto.HandleException;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String message){
        super(message);
    }
}
