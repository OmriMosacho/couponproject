package Project.Coupons.coupon_projectSPRING.webServices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.Customer;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.repositories.companyRepository;
import Project.Coupons.coupon_projectSPRING.repositories.couponRepository;
import Project.Coupons.coupon_projectSPRING.repositories.customerRepository;
import Project.Coupons.coupon_projectSPRING.services.CustomerServiceImplementation;

@RestController
@RequestMapping("rest/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImplementation customer;
	
	@Autowired
	couponRepository couponRep ;
	
	@Autowired
	customerRepository rep ;
	
	@RequestMapping(path = "purchasecoupon/{couponid}" , method=RequestMethod.POST)
	public Coupon purchaseCoupon(@PathVariable long couponid, HttpSession s) throws Exception {
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		Customer c = rep.findByName(user.getName()).get();
		return customer.purchaseCoupon(couponid, c.getId());
	}
	
	@RequestMapping(path = "allpurchased" , method=RequestMethod.GET)
	public List<Coupon>getAllPurchasedCoupons(HttpSession s){
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		Customer c = rep.findByName(user.getName()).get();
		return customer.getAllPurchasedCoupons(c.getId());
	}
	
	@RequestMapping(path = "allpurchasedbytype/{type}" , method=RequestMethod.GET)
	public List<Coupon>getAllPurchasedCouponsByType(HttpSession s , @PathVariable String type){
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		Customer c = rep.findByName(user.getName()).get();
		type = type.toUpperCase();
		System.out.println(type);
		return customer.getAllPurchasedCouponsByType(c.getId(), CouponType.valueOf(type));
	}
	
	@RequestMapping(path = "allpurchasedbyprice/{price}" , method=RequestMethod.GET)
	public List<Coupon>getAllPurchasedCouponsByPrice(HttpSession s , @PathVariable double price){
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		Customer c = rep.findByName(user.getName()).get();
		return customer.getAllPurchasedCouponsByPrice(c.getId(), price);
	}
	
	@RequestMapping(path="getallcoupons" , method=RequestMethod.GET)
	public List<Coupon>getAllCoupons(){
		return couponRep.getAllCouponss();
	}

}
