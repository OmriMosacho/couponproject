package Project.Coupons.coupon_projectSPRING.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String name ;
	@Size(min=5 , max=20)
	private String password ;
	@ManyToMany(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Coupon> coupons;
	
	/**
	 * Constructor 
	 * @param compName - unique
	 * @param password
	 * @param email
	 */
	public Customer( String custName, String password) {
		this.name = custName;
		this.password = password;
	}
	
	/**
	 * Empty constructor
	 */
	public Customer() {}
	
	//Getters and setters 

	public String getName() {
		return name;
	}

	public void setName(String custName) {
		this.name = custName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Coupon> getCoupons() {
		return (List<Coupon>) coupons;
	}

	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}
	
	public void setId(long id) {
		this.id = id ;
	}

	public long getId() {
		return id;
	}
	
	public void add (Coupon c) {
		this.coupons.add(c);
	}
	

	/**
	 * toString method , unique display , not the default
	 */
	@Override
	public String toString() {
		return "Customet --> id = " + id + ", custName = " + name + ", password = " + password 
				+ ", coupons = " + coupons+"\n" ;
	}
}
