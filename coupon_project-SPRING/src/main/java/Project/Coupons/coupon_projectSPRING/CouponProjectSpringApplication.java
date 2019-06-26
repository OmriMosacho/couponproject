package Project.Coupons.coupon_projectSPRING;

import java.sql.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.Customer;
import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.entities.clientType;
import Project.Coupons.coupon_projectSPRING.services.CompanyServiceImplementation;
import Project.Coupons.coupon_projectSPRING.services.CustomerServiceImplementation;
import Project.Coupons.coupon_projectSPRING.services.adminService;
import Project.Coupons.coupon_projectSPRING.services.adminServiceImpementation;

@SpringBootApplication
@ServletComponentScan
public class CouponProjectSpringApplication {

	public static void main(String[] args) throws Exception {
		
		
		
		ConfigurableApplicationContext context = SpringApplication.run(CouponProjectSpringApplication.class, args);
		
		
		
		//adminServiceImpementation admin = (adminServiceImpementation) context.getBean("adminServiceImpementation");
		//Company company = new Company("Nike", "12345", "adidas@adidas.com");
		//admin.creatCompany(company);
		//admin.removeCompany(company);
		//admin.updateCompany(company);
		//System.out.println(admin.getCompany(16));
		//System.out.println(admin.getAllCompanies());
		
		//Customer customer = new Customer("sagi", "121412345");
		
		//admin.createCustomer(customer);
		//admin.removeCustomer(customer);
		//admin.updateCustomer(customer);
		//System.out.println(  admin.getCustomer(1)  );
		//System.out.println(  admin.getAllCustomer()  );
		
		//System.out.println(  admin.login("admin", "1234", clientType.ADMIN)  );
		
//		CompanyServiceImplementation company = (CompanyServiceImplementation) context.getBean("companyServiceImplementation");
//		
//		String date = "2019-05-28" ;
//		Date endDate = Date.valueOf(date);
//		Coupon coupon = new Coupon("apple pie", new Date(System.currentTimeMillis()), endDate, 5, CouponType.FOOD, "no message here !", 20, "Image");
//		
//		LoggedUser lu = (company.login("ADIDAS", "123456789", clientType.COMPANY)) ;
		
		//company.createCoupon(coupon , lu.getId());
		//company.removeCoupon(coupon);
		//company.updateCoupon(coupon , lu.getId());
		//System.out.println(company.getCoupon(14));
		//System.out.println(  company.getAllCoupons(lu.getId())  );
		
		
//		
//		CustomerServiceImplementation customer = (CustomerServiceImplementation) context.getBean("customerServiceImplementation");
//			
//		LoggedUser lu = (customer.login("omri", "123456789", clientType.CUSTOMER));
//		
		//customer.purchaseCoupon(1, lu.getId());
		//System.out.println(customer.getAllPurchasedCoupons(lu.getId()));
		//System.out.println(  customer.getAllPurchasedCouponsByPrice(lu.getId(),20)) ;
		//System.out.println(  customer.getAllPurchasedCouponsByType(lu.getId(), CouponType.FOOD)  );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
