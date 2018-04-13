package util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class forward {
	@RequestMapping("/forward")
    public String hello(String forwardPage){       
        return forwardPage;
    }
}