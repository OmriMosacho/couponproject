package Project.Coupons.coupon_projectSPRING.repositories;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Project.Coupons.coupon_projectSPRING.entities.Company;
import Project.Coupons.coupon_projectSPRING.entities.Coupon;

@Repository
public interface companyRepository extends JpaRepository<Company, Long>{
	
	
	
	
	public Optional<Company> findByName(String name);
	
	
	
	/**
	 * get coupons by company id
	 * @param id
	 * @return all coupons of a single company
	 */
	@Query("select c from Coupon c join c.company com where com.id = ?1")
	public ArrayList<Coupon> getCoupons(long id);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Company c SET c.password = :password , c.email = :email where c.id= :id")
	public void updateCompany( @Param("password") String password, @Param("email") String email, @Param("id") long id);
	
	
	public ArrayList<Company> findByNameAndPassword(String compName , String password);

	

}
