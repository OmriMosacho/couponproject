package Project.Coupons.coupon_projectSPRING.repositories;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import Project.Coupons.coupon_projectSPRING.entities.CouponType;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;

@Repository
public interface couponRepository extends JpaRepository<Coupon, Long>{
	
	/**
	 * @param id
	 * @return all coupons by company's id
	 */
	@Query("select c from Coupon c where c.company.id =:id ")
	public List<Coupon> getAllCopons(@Param("id")long id) ;
	
	////////////
	/**
	 * @param type
	 * @param id
	 * @return all coupons of a specific type
	 * if not found any coupon @throws NotFoundException
	 */
	@Query("select c from Coupon c where c.type = :type and c.company.id = :companyid ")
	public ArrayList<Coupon> getCouponByType(@Param("type")CouponType type ,@Param("companyid")  long companyid) ;

	public Optional<Coupon> findByTitle(String title);
	
	@Query("select c from Coupon c")
	public ArrayList<Coupon> getAllCouponss() ;
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from Coupon c where c.company.id = :companyid")
	public void deleteByCompanyId(@Param("companyid")  long companyid);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Coupon c SET c.price= :price , c.endDate = :endDate , c.amount = :amount where c.id = :id")
	public void updateCoupon(@Param("price") double price, @Param("endDate") Date endDate, @Param("amount") int amount, @Param("id") long id);
	
	@Transactional
	@Modifying
	@Query("delete from Coupon c where c.id =:couponid and c.company.id =:companyid")
	public void removecoupon( @Param("couponid")  long couponid ,@Param("companyid")  long companyid );
	
	
	
}
