package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class controller {
 
    @RequestMapping("/hello")
    public String hello(){        
        return "hellowolrd";
    }
    
    
}