package Project.Coupons.coupon_projectSPRING.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.ValidationException;

import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Customer;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;
import javassist.NotFoundException;

public interface adminService {
	
	/**
	 * create company , used by admin
	 * @param company
	 */
	public void creatCompany(Company company) throws ValidationException ;	//save
	
	/**
	 * removes company 
	 * @param company
	 */
	public void removeCompany(long id) ;	//delete
	
	/**
	 * Updating email and password of company selected by it's name
	 * @param password
	 * @param Email
	 * @param id
	 */
	public void updateCompany( Company company ) ;	//save
	
	/**
	 * return company by id .
	 * @param id
	 * @return Company
	 * @throws NotFoundException 
	 */
	public Company getCompany(long id) throws NotFoundException ;	//find
	

	/**
	 * 
	 * @return Array List of all companies
	 */
	public ArrayList<Company> getAllCompanies() ;	//findAll
	
	/**
	 * create customer
	 * @param customer
	 */
	public void createCustomer(Customer customer);	//save
	
	/**
	 * remove customer
	 * @param customer 
	 */
	public void removeCustomer(long id) ;	//delete
	
	/**
	 * updating the customer's name and password by his id .
	 * @param new customer
	 */
	public void updateCustomer(Customer customer) ;	//save
	
	/**
	 * @param id
	 * @return customer founded by id .
	 * @throws NotFoundException 
	 */
	public Customer getCustomer(long id) throws NotFoundException;	//findById
	
	/**
	 * @return arrayList of all customers
	 */
	public ArrayList<Customer> getAllCustomer() ;	//findAll
	

	/**
	 * log in as a company
	 * @param compName
	 * @param password
	 * @param type
	 * @return the company whom logged in or -1 if could not sign in 
	 */
	
	public LoggedUser login(String name , String password , clientType type);

	
	
	
	

}
