package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;

@Controller

public class LoginCheck {

	@RequestMapping("/login")
	public String login(User user){
	//	System.out.println(name+pwd);
		String name = user.getPwd();
		System.out.println(name);
	    return "homepage";
	}
}
