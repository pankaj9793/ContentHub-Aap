package in.pk.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.pk.main.entities.Post;
import in.pk.main.entities.User;
import in.pk.main.repositories.PostRepository;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import in.pk.main.repositories.UserRepository;
@Controller
public class DashboardController {

	@Autowired
	private UserRepository userRepository;

	
	
    @Autowired
    private PostRepository postRepository;

 
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }

        return "dashboard";
    }

   
    @GetMapping("/add")
    public String addPage(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return "redirect:/login";
        }
        return "add";
    }

    
    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post, HttpSession session) {

        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/login";
        }

        post.setUser(user); // 🔥 MOST IMPORTANT

        postRepository.save(post);

        return "redirect:/view";
    }

  
    @GetMapping("/view")
    public String view(Model model, HttpSession session) {

        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("posts", postRepository.findByUser(user));

        return "view";
    }

   
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        postRepository.deleteById(id);
        return "redirect:/view";
    }

  
    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {

        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);

        return "profile";
    }
    @PostMapping("/uploadPhoto")
    public String uploadPhoto(@RequestParam("image") MultipartFile file,
                              HttpSession session) {

        User user = (User) session.getAttribute("currentUser");

        try {

            if (!file.isEmpty()) {

                String path = "src/main/resources/static/images/";

                File saveFile = new File(path + file.getOriginalFilename());

                FileOutputStream fos = new FileOutputStream(saveFile);
                fos.write(file.getBytes());
                fos.close();

                user.setImageUrl(file.getOriginalFilename());
                userRepository.save(user);

             
                session.setAttribute("currentUser", user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/dashboard";
    }
}
