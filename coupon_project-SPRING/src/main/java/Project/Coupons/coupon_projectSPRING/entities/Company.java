package Project.Coupons.coupon_projectSPRING.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name ;
	@Size(min=5 , max=20)
	private String password ;
	@Email
	private String email;
	
	@OneToMany(mappedBy = "company")
	@JsonIgnore
	List<Coupon> coupons ;
	
	/**
	 * Constructor 
	 * @param id
	 * @param compName
	 * @param password
	 * @param email
	 * @param coupons ArrayList of coupons.
	 */
	public Company( String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public Company ( long id , String password, String email) {
		this.id =id ;
		this.password = password;
		this.email = email;
	}
	
	
	/**
	 * Empty constructor
	 */
	public Company() {}

	
	//Getters and setters 

	public String getName() {
		return name;
	}

	public void setName(String compName) {
		this.name = compName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	



	/**
	 * toString method , unique display , not the default
	 */
	@Override
	public String toString() {
		return "company--> id = "+id+" , company name : "+name+" , password = "+password+", email : "+email+ "\n" ;
	}
	
	
	
	
	
	

}
