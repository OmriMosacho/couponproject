package Project.Coupons.coupon_projectSPRING.Exceptions;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus status ;
	private List<String> message ;
	
	public ApiError(HttpStatus status, String... message) {
		this.status = status;
		this.message = Arrays.asList(message);
	}
	
	public void addMessage(String message) {
		this.message.add(message);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

}
