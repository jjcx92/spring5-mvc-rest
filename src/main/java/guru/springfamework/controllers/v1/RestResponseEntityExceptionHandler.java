package guru.springfamework.controllers.v1;

import guru.springfamework.service.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/**
 * Juerghens castro on 07-08-20 and  07:49 AM to 2020
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object>handleNotException(Exception exception, WebRequest request) {
        return  new ResponseEntity<Object>("Resource Not Found",new HttpHeaders()  , HttpStatus.NOT_FOUND);
    }


}
