package contocorrente.conto.HandleException;

public class NotFoundException extends RuntimeException {
    
    public static NotFoundException of(String message){
        return new NotFoundException(message);
    }
    
    public static void throwNew(String message){

        throw NotFoundException.of(message);

    }

    private NotFoundException(String message){
        super(message);
    }
    
}
