package api.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public final ResponseEntity<ErrorMessage> handleUserNotFoundException(Exception exception, WebRequest request) {
        ErrorMessage errorDetails = new ErrorMessage(LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
