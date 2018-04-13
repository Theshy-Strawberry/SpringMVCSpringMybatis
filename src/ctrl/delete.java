package ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.deleteUserDao;

@Controller
public class delete {
@RequestMapping("/delete")
	public String  delete(String name) {
		deleteUserDao dao = new deleteUserDao();
		boolean flag = dao.delete(name);
		if(flag){
			return "redirect:/alluser";
		}else{
			return "error";
		}
	}
@RequestMapping("/deletes")
public void  deletes(String name,HttpServletResponse resp) throws IOException {
	deleteUserDao dao = new deleteUserDao();
	boolean flag = false ;
	flag = true;//dao.deletes(name);
//		 JSONArray  json = JSONArray.fromObject(flag);
	 if(flag){
		 resp.getWriter().print("true");
	 }else{
		 resp.getWriter().print("false");
	 }
	 
}

}
