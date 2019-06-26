package Project.Coupons.coupon_projectSPRING.webServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Project.Coupons.coupon_projectSPRING.entities.LoggedUser;
import Project.Coupons.coupon_projectSPRING.services.LoginService;


@RestController
@RequestMapping("login")
public class ClientController {
	
	@Autowired
	LoginService login ;
	
	@RequestMapping( method=RequestMethod.POST)
	public LoggedUser login (@RequestBody LoggedUser user , HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		session = request.getSession();
		LoggedUser newUser = login.login(user.getName(), user.getPassword(), user.getType());
		session.setAttribute("user", user);
		session.setAttribute("clientType",user.getType());
		
		return newUser ;
	}
	
	
}
