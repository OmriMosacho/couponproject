package Project.Coupons.coupon_projectSPRING.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class LoggedUser {
	
	@Enumerated(EnumType.STRING)
	private clientType type ;
	private String name , password ;
	
	public LoggedUser(clientType type, String name, String password) {
		this.type = type;
		this.name = name;
		this.password = password;
	}
	
	public LoggedUser() {}

	public clientType getType() {
		return type;
	}

	public void setType(clientType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoggedUser [type=" + type + ", name=" + name + ", password=" + password + "]";
	}

	
	
	


}
