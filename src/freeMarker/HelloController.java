package freeMarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
//	@Autowired
//	Animal dog;
	@RequestMapping("/fff")
	public ModelAndView  showInfo(){
		Animal dog =new Animal();
		ModelAndView mv = new ModelAndView("hello");
		dog.setName("hashiqi");
		dog.setPrice(666);
		mv.addObject("dog",dog);
		return mv;
	}
}
