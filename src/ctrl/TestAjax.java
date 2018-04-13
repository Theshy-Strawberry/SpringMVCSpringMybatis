package ctrl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;



@Controller
public class TestAjax  {
@RequestMapping("testAjax")
public void testAjax(int a,String b,HttpServletResponse response){
// String name= request.getParameter("a");	
// String name2= request.getParameter("b");	
//	try {
//		response.getWriter().write(a+b);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	  Map<String,Object> map = new HashMap<String,Object>();
  
	List<String> list= new ArrayList<String>();
	list.add("fst");
	list.add("sed");
	list.add("thd");
	list.add(b);
	String test="zz";
	   map.put( "list", list);
	   map.put( "test", test);
	// JSONArray json= JSONArray.fromObject(list);
	   
	   User user = new User();
	   user.setName("s");
	   user.setPwd("b");
	//String json=JSONObject.fromObject(user).toString();
//	String json2= JSONArray.fromObject(list).toString();
	String json2= JSONObject.fromObject(map).toString();
	
	
	try {
		//response.getWriter().write(json);
		response.getWriter().print(json2);
	//	response.getWriter().print(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
