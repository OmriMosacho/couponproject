package Project.Coupons.coupon_projectSPRING.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import Project.Coupons.coupon_projectSPRING.Exceptions.ActionNotAllowedException;
import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;
import javassist.NotFoundException;



public interface companyService {
	
	
	/**
	 * create coupon and connect it to the same company who called the method
	 * @param coupons
	 * @param compid
	 * @throws UniqueValueException
	 */
	public void createCoupon(Coupon coupons , long companyid );	//save
	/**
	 * removes coupon 
	 * @param coupons
	 * if not found this coupon @throws NotFoundException
	 */
	public void removeCoupon(long couponid , long companyid)throws Exception;	//delete
	/**
	 * updating date and price of a coupon 
	 * @param id - coupon id
	 * @param date
	 * @param price
	 * if not found this coupon @throws NotFoundException
	 */
	public void updateCoupon(Coupon coupons , long companyid);
	/**
	 * returns coupon by it's id
	 * @param id
	 * @return coupon founded
	 * if not found this coupon @throws NotFoundException
	 * @throws ActionNotAllowedException 
	 * @throws NotFoundException 
	 */
	
	public Coupon getCoupon(long id, long companyid) throws ActionNotAllowedException, NotFoundException  ;	//findById
	
	
	/**
	 * 
	 * @param type
	 * @param id
	 * @return all coupons of a specific type
	 * if not found any coupon @throws NotFoundException
	 */
	public ArrayList<Coupon> getCouponByType(CouponType types , long id ) ;
	
	
	/**
	 * log in as a company
	 * @param compName
	 * @param password
	 * @param type
	 * @return the company whom logged in or -1 if could not sign in 
	 */
	public LoggedUser login(String compName , String password , clientType type);
	void removeCoupon2(long couponid) throws Exception;

	

}
