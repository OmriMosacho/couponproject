package Project.Coupons.coupon_projectSPRING.services;

import java.util.ArrayList;
import java.util.Date;
import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.Customer;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;
import Project.Coupons.coupon_projectSPRING.repositories.couponRepository;
import Project.Coupons.coupon_projectSPRING.repositories.customerRepository;

@Service
public class CustomerServiceImplementation implements customerService {
	
	@Autowired
	public customerRepository customerRep ;
	
	@Autowired
	public couponRepository couponRep ;

	
	@Transactional
	@Override
	public Coupon purchaseCoupon(long couponid, long customerid) throws ValidationException {
		
		Coupon checkCoupon = couponRep.findById(couponid).get();
		if(checkCoupon==null) {
			throw new ValidationException("Cannot buy coupon ,this coupon is not exist !");
		}Coupon couponCustomer = customerRep.getCoupon(couponid, customerid);
		if(couponCustomer != null) {
			throw new ValidationException("Cannot buy coupon ,this coupon was already purchased !");
		}if(checkCoupon.getAmount() <= 0) {
			throw new ValidationException("Cannot buy coupon ,this coupon was sold out ...");
		}if(checkCoupon.getEndDate().before(new Date( System.currentTimeMillis() ))){
			throw new ValidationException("Cannot buy coupon ,this coupon is expired !");
		}
		Customer customer = customerRep.findById(customerid).get();
		System.out.println(customer);
		System.out.println(checkCoupon);
		
		//checkCoupon
		customer.add(checkCoupon);
		
		checkCoupon.setAmount(checkCoupon.getAmount()-1);
		//couponRep.save(checkCoupon);
		//customerRep.save(customer);
		return checkCoupon;
		
	}
	
	public ArrayList<Coupon> getAllPurchasedCoupons(long custId){
		return customerRep.getAllPurchasedCoupons(custId);
	}
	
	public ArrayList<Coupon> getAllPurchasedCouponsByType(long custId,CouponType type){
		return customerRep.getAllPurchasedCouponsByType(custId, type);
	}
	
	public ArrayList<Coupon> getAllPurchasedCouponsByPrice(long custId , double price){
		return customerRep.getAllPurchasedCouponsByPrice(custId, price);
	}
	
	

	@Override
	public LoggedUser login(String custName, String password, clientType type) {
		ArrayList<Customer> customer = customerRep.findByNameAndPassword(custName,password);
		if(!customer.isEmpty()) {
			return new LoggedUser(clientType.CUSTOMER, custName, password);
			
		}return  new LoggedUser();
	}

}
