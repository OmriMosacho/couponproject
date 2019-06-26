package Project.Coupons.coupon_projectSPRING.Exceptions;

import javax.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javassist.NotFoundException;

@ControllerAdvice
public class ExceptionHandler1 {
	

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> HandleValidationException(ValidationException e){
		ApiError apiError ;
		if(e.getMessage().contains("propertyPath=password")) {
			apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "password must be between 5 - 20");
		}
		else apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		return new ResponseEntity<Object>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> HandleNotFoundException(NotFoundException e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getMessage());
		return new ResponseEntity<Object>(apiError, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> HandleNullPointerException(NullPointerException e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Sorry, what you are looking for does not exist...");
		return new ResponseEntity<Object>(apiError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SQLServerException.class)
	public ResponseEntity<?> HandleSQLServerException(SQLServerException e){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Sorry, something went wrong...");
		if(e.getMessage().contains("Violation of UNIQUE KEY")) {
			apiError = new ApiError(HttpStatus.BAD_REQUEST, "name or title already exist");
		}
		return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
	}
	
	//GENERAL
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> HandleGeneral(Exception e){
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Sorry, something went wrong...");
		return new ResponseEntity<Object>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ActionNotAllowedException.class)
	public ResponseEntity<?> HandleActionNotAllowedException(ActionNotAllowedException e){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "You are not autorized to do this action !");
		return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
	}
	
}
