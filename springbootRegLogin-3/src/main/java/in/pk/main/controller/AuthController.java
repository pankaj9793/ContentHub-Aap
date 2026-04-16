package in.pk.main.controller;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import in.pk.main.entities.User;
import in.pk.main.repositories.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

   
    @PostMapping("/registerForm")
    public String registerUser(@ModelAttribute User user, Model model) {

        try {
            user.setRole("ROLE_USER");
            user.setEnabled(true);

            userRepository.save(user);

            model.addAttribute("msg", "Registration Successful!");

            return "login"; 

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "Error in Registration");

            return "signup"; 
        }
    }

    

    @PostMapping("/loginForm")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session,
                            Model model) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {

            session.setAttribute("currentUser", user); 
            session.setAttribute("currentUser", user);
            return "redirect:/dashboard"; 
           

        } else {

            model.addAttribute("msg", "Invalid Email or Password");
            return "login";
        }
    }

  
    
}

