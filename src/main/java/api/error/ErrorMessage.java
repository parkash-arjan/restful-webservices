package api.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private HttpStatus httpStatus;
}
