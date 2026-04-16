package in.pk.main.controller;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.pk.main.entities.User;

@Controller
public class HomeController {

	
   
    @GetMapping("/")
    public String home() {
        return "index";   
    }

  
    @GetMapping("/about")
    public String about() {
        return "about";   
    }

   
    @GetMapping("/login")
    public String login() {
        return "login";   
    }

 
    @GetMapping("/signup")
    public String signup() {
        return "signup"; 
    }

  
   

   

    


}
