package Project.Coupons.coupon_projectSPRING.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.mockito.internal.matchers.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;
import Project.Coupons.coupon_projectSPRING.entities.Customer;

@Repository
public interface customerRepository extends JpaRepository<Customer, Long>{
	
	
	/**
	 * 
	 * @return ArrayList of all coupons 
	 * @throws SQLException
	 * @throws NotFoundException if not found any coupons
	 */
	@Query("select c from Coupon c ")
	public ArrayList<Coupon> getCoupons() ;
	

	
	/**
	 * 
	 * @return ArrayList of all purchased coupons of the customer
	 * @throws NotFoundException if no coupon found
	 * @throws SQLException
	 */
	@Query("select c from Coupon c join c.customers cc where cc.id = ?1 ")
	public ArrayList<Coupon> getAllPurchasedCoupons(long custId) ;
	
	/**
	 * 
	 * @param type - type of coupon you want to get
	 * @return arrayList of coupons from a specific type
	 * @throws NotFoundException if not found any
	 * @throws SQLException
	 */
	@Query("select c from Coupon c join c.customers cc where cc.id = ?1 and c.type like ?2 ")
	public ArrayList<Coupon> getAllPurchasedCouponsByType(long custId,CouponType type);
	/**
	 * @param price - max price of coupons you want to get
	 * @return arrayList of coupons by a maximum price
	 * @throws NotFoundException if not found any
	 * @throws SQLException
	 */
	@Query("select c from Coupon c join c.customers cc where cc.id = ?1 and c.price < ?2 ")
	public ArrayList<Coupon> getAllPurchasedCouponsByPrice(long custId , double price);

	
	@Query("select c from Coupon c join c.customers cc where c.id = ?1 and cc.id = ?2 ")
	public Coupon getCoupon(long couponid , long custid );
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Customer c SET c.password = :password where c.id= :id")
	public void updateCustomer( @Param("password") String password, @Param("id") long id);
	
	
	public ArrayList<Customer> findByNameAndPassword(String custName,String password);


	public Optional<Customer> findByName(String custName);
	
	
}

	
