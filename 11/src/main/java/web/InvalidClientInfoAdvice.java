package web;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
class InvalidClientInfoAdvice {
 @ResponseBody
 @ExceptionHandler(InvalidClientInfoException.class)
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 String invalidClientInfo(InvalidClientInfoException ex) {
 return ex.getMessage();
 }
}