package ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;
import mapper.TestMybatisInt;

@Controller
public class TestMybatis {
	@Resource
	private TestMybatisInt dao;
    @RequestMapping("/testMybatis")
	public  String  insert(User user){
		dao.deleteTest(user);
			return "homepage";
		}
}
