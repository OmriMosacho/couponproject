package Project.Coupons.coupon_projectSPRING.services;

import java.sql.SQLException;

import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;

public interface customerService {
	
	
	/**
	 * @param c - coupon
	 */
	public Coupon purchaseCoupon(long couponid, long customerid) ; 
	
	
	
	/**
	 * 
	 * @param custName - customer's name
	 * @param password - customer's password
	 * @param type - customer as a client type
	 * @return - the customer's id.
	 * @throws SQLException
	 */
	public LoggedUser login(String custName , String password , clientType type) ;
	
	
	
}
