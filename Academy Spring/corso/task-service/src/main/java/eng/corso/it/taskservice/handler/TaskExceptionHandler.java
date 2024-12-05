package eng.corso.it.taskservice.handler;

import eng.corso.it.taskservice.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class TaskExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> noDataFounfExceptionHandler(NoDataFoundException e){
        HashMap<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now() );
        body.put("ERROR_CODE", "1000"); //questi error code sono dichiarati in un dizionario insieme al front end
        body.put("message", "non ho trovato il task con l'id richiesto.");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
