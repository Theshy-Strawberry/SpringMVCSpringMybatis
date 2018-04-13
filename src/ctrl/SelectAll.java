package ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.User;
import dao.SelectAllUserDao;


@Controller
public class SelectAll {
@RequestMapping("alluser")
	public String selectAll(ModelMap model){
		
 	SelectAllUserDao selectall = new SelectAllUserDao();
	List<User> resultList =  selectall.selectall();
	model.put("userlist", resultList);
	model.put("test", "can i  be found ?");
	
	model.addAttribute("greetings", "I came from Model not ModelAttribute"); 
	String[] maybe= new String [5];
	maybe[0]="woyan";
	maybe[1]="baolan";
	maybe[2]="enjing";
	maybe[3]="suyan";
	maybe[4]="furen";
	model.put("tara", maybe);
	//model.addAttribute("userList", resultList); 
//	ModelAndView mv= new ModelAndView();
//	mv=new ModelAndView("/indexAll", maps);
	return "userlist";
}
@RequestMapping("searckByKey")
public String selectByKey(ModelMap model,String key,HttpServletResponse response){
	
	SelectAllUserDao selectall = new SelectAllUserDao();
	List<User> resultList =  selectall.selectallBykey(key);

	String json= JSONArray.fromObject(resultList).toString();
//	model.put("baochi", key);
	model.addAttribute("baochi", key);
	model.addAttribute(key);
	try {
		response.getWriter().print(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//model.addAttribute("userList", resultList); 
//	ModelAndView mv= new ModelAndView();
//	mv=new ModelAndView("/indexAll", maps);
	return "userlist";
}
@RequestMapping("ByKey")
public ModelAndView  ByKey(ModelMap model,String key,HttpServletResponse response){
	
	SelectAllUserDao selectall = new SelectAllUserDao();
	List<User> resultList =  selectall.selectallBykey(key);
	 model.put("userlist", resultList);
	//model.addAttribute("userList", resultList); 
//	ModelAndView mv= new ModelAndView();
//	mv=
	 return new ModelAndView("userlist", model);
}
@RequestMapping("TestKey/{xinsai}")
public ModelAndView  Test(ModelMap model,@PathVariable("xinsai")String key,HttpServletResponse response){
	
	SelectAllUserDao selectall = new SelectAllUserDao();
	List<User> resultList =  selectall.selectallBykey(key);
	model.put("userlist", resultList);
	//model.addAttribute("userList", resultList); 
//	ModelAndView mv= new ModelAndView();
//	mv=
	return new ModelAndView("userlist", model);
}



//测试下 使用接口
@RequestMapping("testInterface")
public String allgoods(String id,ModelMap model){
	
SelectAllUserDao selectall = new SelectAllUserDao();
List<User> resultList =  selectall.testInterface(id);
net.sf.json.JSONArray jsonArray =net.sf.json.JSONArray.fromObject(resultList);
model.addAttribute("username", jsonArray.toString());  
return "jjjjjason";
}
}
