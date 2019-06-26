package Project.Coupons.coupon_projectSPRING.entities;


import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PositiveOrZero;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Coupon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected long id ;
	@Column(unique=true)
	protected String title ;
	protected String message ;
	protected String image ;
	protected Date startDate , endDate ;
	@PositiveOrZero
	protected int amount ;
	@Enumerated(EnumType.STRING)
	protected CouponType type ;
	@PositiveOrZero
	protected double price;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnore
	protected Company company;
	
	@ManyToMany(mappedBy="coupons" , fetch=FetchType.EAGER)
	@JsonIgnore
	protected List<Customer> customers;
	
	public Coupon() {}
	
/**
 * constructor - getting all as parameters
 * @param id
 * @param title - unique
 * @param message - a description of the coupon
 * @param image
 * @param startDate
 * @param endDate (expiration date)
 * @param amount in stock
 * @param type
 * @param price in dollars
 */
	public Coupon( String title,  Date startDate, Date endDate,int amount,
			CouponType type,String message, double price , String image) {
		this.title = title;
		this.message = message;
		this.image = image;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.type = type;
		this.price = price;
	}
	
	public Coupon( long id, Date endDate, double price , int amount ) {
		this.id=id;
		this.endDate = endDate;
		this.price = price;
		this.amount = amount;
	}
	
	//Getters and setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void add(Customer c) {
		this.customers.add(c);
	}
	
	

	/**
	 * toString method , unique display , not the default
	 */
	@Override
	public String toString() {
		return "Coupon --> id=" + id + ", title = " + title + ", message = " + message + ", image = " + image + ", startDate = "
				+ startDate + ", endDate = " + endDate + ", amount = " + amount + ", type = " + type + ", price = " + price + "\n";  
	}


	
	
	
	
	


}
