package Project.Coupons.coupon_projectSPRING.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Customer;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;
import Project.Coupons.coupon_projectSPRING.repositories.companyRepository;
import Project.Coupons.coupon_projectSPRING.repositories.couponRepository;
import Project.Coupons.coupon_projectSPRING.repositories.customerRepository;
import javassist.NotFoundException;

@Service
public class adminServiceImpementation implements adminService {
	
	@Autowired
	public companyRepository companyRep;
	
	@Autowired
	public customerRepository customerRep;
	
	@Autowired
	public couponRepository couponRep ;
	

	@Transactional
	@Override
	public void creatCompany(Company company) throws ValidationException {
		if(!companyRep.findByName(company.getName()).isPresent()){
			companyRep.save(company);
		}else {
			throw new ValidationException("Company name ,already exist..");
		}
		
	}
	
	@Transactional
	@Modifying
	@Override
	public void removeCompany(long id ) {
		if(!companyRep.getCoupons(id).isEmpty()) {
		couponRep.deleteByCompanyId(id);
		}
		companyRep.deleteById(id);
	}

	@Override
	public void updateCompany(Company company) {
		companyRep.updateCompany( company.getPassword(), company.getEmail() , company.getId());
	}

	@Override
	public Company getCompany(long id) throws NotFoundException {
		try {
		return companyRep.findById(id).get();
		}catch(NoSuchElementException  | MethodArgumentTypeMismatchException  e){
			throw new NotFoundException("we're sorry ,this Company is not exist...");
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() {
		return  (ArrayList<Company>) companyRep.findAll();
	}

	@Override
	public void createCustomer(Customer customer) {
		customerRep.save(customer);
	}

	@Override
	public void removeCustomer(long id) {
		//Optional<Customer>custwithid = customerRep.findByName(customer.getName());
		customerRep.deleteById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRep.updateCustomer( customer.getPassword(), customer.getId());
	}

	@Override
	public Customer getCustomer(long id) throws NotFoundException {
		try {
		return customerRep.findById(id).get();
		}catch(NoSuchElementException | MethodArgumentTypeMismatchException  e){
			throw new NotFoundException("we're sorry ,this Customer is not exist...");
		}
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		return (ArrayList<Customer>) customerRep.findAll();
	}

	@Override
	public LoggedUser login(String name, String password, clientType type) {
		if(name.equals("admin") && password.equals("1234") && type.equals(clientType.valueOf("ADMIN"))) {
			return new LoggedUser(clientType.ADMIN, "admin", "1234");
		}
		return new LoggedUser();
	}

	
	
}