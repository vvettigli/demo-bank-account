package contocorrente.conto.HandleException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ApiError {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timeStamp;
}
