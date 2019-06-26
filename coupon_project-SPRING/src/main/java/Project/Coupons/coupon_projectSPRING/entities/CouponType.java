package Project.Coupons.coupon_projectSPRING.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CouponType {
	@JsonProperty("resturants")
	RESTURANTS ,
	@JsonProperty("electricity")
	ELECTRICITY ,
	@JsonProperty("food")
	FOOD ,
	@JsonProperty("health")
	HEALTH , 
	@JsonProperty("sports")
	SPORTS ,
	@JsonProperty("camping")
	CAMPING ,
	@JsonProperty("traveling")
	TRAVELING

}
