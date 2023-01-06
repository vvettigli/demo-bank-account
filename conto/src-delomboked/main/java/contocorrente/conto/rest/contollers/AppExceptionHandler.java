package contocorrente.conto.rest.contollers;

import java.time.LocalDateTime;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import contocorrente.conto.HandleException.AlreadyExistsException;
import contocorrente.conto.HandleException.ApiError;
import contocorrente.conto.HandleException.NotFoundException;
import contocorrente.conto.HandleException.NullException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    
    Logger logger = org.slf4j.LoggerFactory.getLogger(AppExceptionHandler.class);
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> HandleNotFountException(NotFoundException ex, WebRequest request ){

        logger.error("interecettato notFoundException", ex);
        return new ResponseEntity<Object>(new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullException.class)
    public ResponseEntity<Object> HandleNullException(NullException ex, WebRequest request ){


        return new ResponseEntity<Object>(new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }   

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Object> HandleAlreadyExistsException(AlreadyExistsException ex, WebRequest request ){


        return new ResponseEntity<Object>(new ApiError(ex.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }   
}
