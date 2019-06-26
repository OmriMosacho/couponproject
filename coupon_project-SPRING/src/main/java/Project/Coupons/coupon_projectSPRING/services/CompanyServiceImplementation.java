package Project.Coupons.coupon_projectSPRING.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project.Coupons.coupon_projectSPRING.Exceptions.ActionNotAllowedException;
import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;
import Project.Coupons.coupon_projectSPRING.repositories.companyRepository;
import Project.Coupons.coupon_projectSPRING.repositories.couponRepository;
import javassist.NotFoundException;

@Service
public class CompanyServiceImplementation implements companyService{


	
	@Autowired
	public couponRepository couponRep ;
	
	@Autowired
	public companyRepository companyRep ;
	

	@Override
	@Transactional
	public void createCoupon(Coupon coupon , long companyid) {
		Optional<Company> company = companyRep.findById(companyid);
		coupon.setCompany(company.get());
		couponRep.save(coupon);
	}

	@Override
	@Transactional
	public void removeCoupon(long couponid , long companyid) throws ActionNotAllowedException {
		Coupon c = couponRep.findById(couponid).get();
		if(c.getCompany().getId() == companyid) {
			couponRep.removecoupon(couponid, companyid);
		}else {
			throw new ActionNotAllowedException("you are not autorized to delete this coupon");
		}
		
	}
	
	@Override
	@Transactional
	public void removeCoupon2(long couponid ) throws Exception {
		Coupon c = couponRep.findById(couponid).get();
		couponRep.delete(c);
	}

	
	@Override
	@Transactional
	public void updateCoupon(Coupon coupon , long companyid) {
		
		Optional<Company> company = companyRep.findById(companyid);
		if(couponRep.existsById(coupon.getId())) {
			coupon.setCompany(company.get());
			System.out.println(coupon.getPrice()+" "+coupon.getEndDate()+" "+coupon.getAmount() +" "+ companyid);
			couponRep.updateCoupon(coupon.getPrice(),coupon.getEndDate(),coupon.getAmount() , coupon.getId());
		}
	}

	@Override
	public Coupon getCoupon(long id, long companyid)throws ActionNotAllowedException, NotFoundException {
		try {
		Coupon c = couponRep.findById(id).get();
		
		if(c.getCompany().getId() == companyid) {
			return c;
		}else {
			throw new ActionNotAllowedException("");
		}
		}catch(NoSuchElementException e) {
			
			throw new NotFoundException("Coupon not found !");
		}
		
		
		
	}
	
	public List<Coupon> getAllCoupons (long companyid) {
	return couponRep.getAllCopons(companyid);

	}
	
	@Override
	public ArrayList<Coupon> getCouponByType(CouponType type , long id) {
		return couponRep.getCouponByType(type , id);
	}
	
	
	
	@Override
	public LoggedUser login(String compName, String password, clientType type) {
		ArrayList<Company> company = companyRep.findByNameAndPassword(compName, password);
		if(!company.isEmpty()) {
			return new LoggedUser(clientType.COMPANY, compName, password);
		}else 
			return  new LoggedUser();
		
	
	}

	

}
