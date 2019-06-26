package Project.Coupons.coupon_projectSPRING.webServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Customer;
import Project.Coupons.coupon_projectSPRING.services.CompanyServiceImplementation;
import Project.Coupons.coupon_projectSPRING.services.adminServiceImpementation;
import javassist.NotFoundException;

@RestController
@RequestMapping("rest/admin")
public class AdminController {
	
	@Autowired
	public adminServiceImpementation admin ;
	
	@Autowired
	public CompanyServiceImplementation company ;

	@RequestMapping(path = "createcompany" , method=RequestMethod.POST)
	public Company createCompany(@RequestBody Company company) {
		admin.creatCompany(company);
		return company;
	}
	
	@RequestMapping(path="removecompany/{id}" , method=RequestMethod.DELETE)
	public boolean removeCompany(@PathVariable long id ) {
		admin.removeCompany(id);
		
		return true ;
	}
	
	@RequestMapping(path = "updatecompany" , method=RequestMethod.PUT)
	public boolean updateCompany(@RequestBody Company company) {
		admin.updateCompany(company);
		return true;
	}
	
	@RequestMapping(path = "getcompany/{companyId}" , method=RequestMethod.GET)
	public Company getCompany(@PathVariable long companyId) throws NotFoundException {
		return admin.getCompany(companyId);
	}
	
	@RequestMapping(path = "getallcompanies" , method=RequestMethod.GET)
	public List<Company> getAllCompanies(){
		return admin.getAllCompanies();
	}
	
	@RequestMapping(path = "createcustomer" , method=RequestMethod.POST)
	public Customer createcustomer(@RequestBody Customer customer) {
		admin.createCustomer(customer);
		return customer;
	}
	
	@RequestMapping(path = "removecustomer/{id}" , method=RequestMethod.DELETE)
	public boolean removecustomer(@PathVariable long id) {
		admin.removeCustomer(id);
		return true;
	}
	
	@RequestMapping(path = "updatecustomer" , method=RequestMethod.PUT)
	public boolean updateCustomer(@RequestBody Customer customer) {
		admin.updateCustomer(customer);
		return true;
	}
	
	@RequestMapping(path = "getcustomer/{customerId}" , method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable long customerId) throws NotFoundException {
		return admin.getCustomer(customerId);
	}
	
	@RequestMapping(path = "getallcustomers" , method = RequestMethod.GET)
	public ArrayList<Customer> getAllCustomers(){
		return admin.getAllCustomer();
	}
	
	
	
	
}
