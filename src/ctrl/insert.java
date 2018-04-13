package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.insertUserDao;

@Controller
public class insert {
@RequestMapping("/insert")
	public  String  insert(@RequestParam String id,@RequestParam String name,@RequestParam String price,@RequestParam String checkList,@RequestParam String fruit) {
	    String a = checkList;
		insertUserDao dao = new insertUserDao();
		boolean flag = dao.insert(id, name, price);
		if(flag){
			//转发到另一个controller
			return "redirect:/alluser";
		}else{
			//转到一个jsp
			return "error";
		}
	}
}
