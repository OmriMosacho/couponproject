package Project.Coupons.coupon_projectSPRING.webServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("logout")
public class Logout {
	
	@RequestMapping( method=RequestMethod.POST)
	public boolean logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return true ;
	}

}
