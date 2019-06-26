package Project.Coupons.coupon_projectSPRING.thread;

import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;


import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.repositories.couponRepository;
import Project.Coupons.coupon_projectSPRING.services.CompanyServiceImplementation;



public class DailyCouponExpirationTask implements Runnable {
	
	private boolean isInterruptes;
	
	@Autowired
	private couponRepository couponRep;
	
	public static ArrayList<Coupon> coupons = new ArrayList<>();
	
	@Autowired
	private CompanyServiceImplementation comp ;
	
	public DailyCouponExpirationTask(){
		
	}
	@Override
	@PostConstruct
	public void run() {
		if(!isInterruptes) {
			DailyCouponExpirationTask.coupons = (ArrayList<Coupon>) couponRep.findAll();
			for (Coupon coupons2 : coupons) {
				Date now = new Date(System.currentTimeMillis());
				if(now.after(coupons2.getEndDate())) {
					try {
						comp.removeCoupon2(coupons2.getId());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				}
				
			try {
				Thread.sleep(60*60*24*1000);
				
			} 	catch (InterruptedException e) {
				System.out.println(e.getMessage());
				}
			}

	}
	/**
	 * activate this method to stop the thread
	 */
	public void stopTask() {
		isInterruptes = Thread.interrupted();
	}
}