package pl.zalwi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    @ResponseBody
    @RequestMapping("/")
    public String index(){
        return "Strona startowa";
    }
}
