package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.updateUserDao;
import bean.User;

@Controller
public class update {
@RequestMapping("/update")
	public String  insert(User user) {
		String name = user.getName();
		String pwd = user.getPwd();
		String sex = user.getSex();
		updateUserDao dao = new updateUserDao();
		boolean flag = dao.update(name, pwd, sex);
		if(flag){
			return "redirect:/alluser";
		}else{
			return "error";
		}
	}
}
