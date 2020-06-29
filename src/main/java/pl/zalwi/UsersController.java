package pl.zalwi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.zalwi.data.User;
import pl.zalwi.data.UserRepository;

@Controller
public class UsersController {

    UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String addUserForm(){
        return "redirect:/index.html";
    }

    @ResponseBody
    @RequestMapping("/users")
    public String listOfUsers(){
        String result = "<b>Lista użytkowników</b><br>";
        for(User user: userRepository.getAll()){
            result += user + "<br>";
        }
        result += "Powrót do <a href='/'>strony głównej</a>";
        return result;
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age){
        if(firstName.length()<1){
            return "redirect:/err.html";
        }
        userRepository.addUser(new User(firstName, lastName, age));
        return "redirect:/success.html";
    }
}
