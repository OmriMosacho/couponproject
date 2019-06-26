package Project.Coupons.coupon_projectSPRING.webServices;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Project.Coupons.coupon_projectSPRING.Exceptions.ActionNotAllowedException;
import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.repositories.companyRepository;
import Project.Coupons.coupon_projectSPRING.services.CompanyServiceImplementation;
import javassist.NotFoundException;

@RestController
@RequestMapping("rest/company")
public class CompanyController {
	
	@Autowired
	 CompanyServiceImplementation company ;
	
	@Autowired
	companyRepository rep ;
	
	@RequestMapping(path = "createcoupon" , method=RequestMethod.POST)
	public Coupon createCoupon(@RequestBody Coupon coupon , HttpSession s) {
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		//String companyname = user.getName();
		Company c = rep.findByName(user.getName()).get();
		company.createCoupon(coupon , c.getId() );
		return coupon;
	}
	
	@RequestMapping(path = "removecoupon/{couponid}" , method=RequestMethod.DELETE)
	public boolean removeCoupon(@PathVariable long couponid , HttpSession s) throws Exception { 
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		Company c = rep.findByName(user.getName()).get();
		company.removeCoupon(couponid , c.getId());
		return true;
	}
	
	@RequestMapping(path = "updatecoupon" , method=RequestMethod.PUT)
	public boolean updateCoupon(@RequestBody Coupon coupon , HttpSession s) {
		try {
			LoggedUser user = (LoggedUser) s.getAttribute("user");
			Company c = rep.findByName(user.getName()).get();
			company.updateCoupon(coupon , c.getId());
			return true ;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@RequestMapping(path = "getcoupon/{id}" , method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable long id , HttpSession s) throws ActionNotAllowedException, NotFoundException {
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		Company c = rep.findByName(user.getName()).get();
		Coupon returnedCoupon = company.getCoupon(id,c.getId());
		return returnedCoupon;
	}
	
	@RequestMapping(path = "getcouponbytype/{type}" , method = RequestMethod.GET)
	public List<Coupon> getCouponByType(@PathVariable String type , HttpSession s) {
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		Company c = rep.findByName(user.getName()).get();
		type = type.toUpperCase() ;
		return company.getCouponByType(CouponType.valueOf(type), c.getId());
	}
	
	
	@RequestMapping(path = "getallcoupons" , method = RequestMethod.GET)
	public List<Coupon> getAllCoupons(HttpSession s){
		LoggedUser user = (LoggedUser) s.getAttribute("user");
		String companyname = user.getName();
		Company c = rep.findByName(user.getName()).get();
		return company.getAllCoupons(c.getId());
	}
	
}
