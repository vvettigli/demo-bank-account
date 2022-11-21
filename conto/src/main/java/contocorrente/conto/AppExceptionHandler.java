package contocorrente.conto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import contocorrente.conto.HandleException.ApiError;
import contocorrente.conto.HandleException.NotFoundException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> HandleNotFountException(NotFoundException ex, WebRequest request ){


        return new ResponseEntity<Object>(new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

}
