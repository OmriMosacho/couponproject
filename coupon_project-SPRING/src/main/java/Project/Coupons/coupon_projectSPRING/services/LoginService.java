package Project.Coupons.coupon_projectSPRING.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;

@Service
public class LoginService {

	
	@Autowired
	public adminServiceImpementation admin;
	
	@Autowired
	public CompanyServiceImplementation company ;
	
	@Autowired
	public CustomerServiceImplementation customer;
	
	
	public LoggedUser login(String name , String password , clientType type) {
		switch(type) {
		case ADMIN :
			return admin.login(name, password, type);
		case COMPANY :
			return company.login(name, password, type);
		case CUSTOMER :
			return customer.login(name, password, type);
		default :
			return null;
		}
	}
	
}
