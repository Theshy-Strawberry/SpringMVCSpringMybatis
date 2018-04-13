package ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;



@Controller
public class AjaxList {

    @RequestMapping("/ajaxList")
    public void hello(HttpServletResponse response){        

		List a = new ArrayList();
		
		a.add("nihao");
		a.add("woxi");
		a.add("meili");
		a.add("yaoyao");
		
		JSONArray json = JSONArray.fromObject(a);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
