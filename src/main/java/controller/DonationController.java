package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Blood;
import com.example.demo.BloodRepository;
import com.example.demo.User;
import com.example.demo.UserRepository;
@Controller
public class DonationController {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BloodRepository bloodrepo;
	
	@GetMapping("")
	public String IndexPage(Model model) {
		return "index";
	}
	
	@GetMapping("/about")
	public String AboutPage() {
		return "about";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    return "signup_form";
	}
	
	@RequestMapping("/causes.html")
	public String CausePage(Model model) {
		return "causes";
	}
	
	@GetMapping("/index")
	public String indexPage(Model model) {
		return "index";
	}
	
	@RequestMapping("/event.html")
	public String EventPage(Model model) {
		return "event";
	}
	
	@RequestMapping("/donate.html")
	public String DonatePage(Model model) {
		return "donate";
	}
	
	@RequestMapping("/contact.html")
	public String ContactPage(Model model) {
		return "contact";
	}
	
	@RequestMapping("/blog.html")
	public String BlogPage(Model model) {
		return "blog";
	}
	
	@RequestMapping("/service.html")
	public String ServicePage(Model model) {
		return "service";
	}
	
	@RequestMapping("/single.html")
	public String SinglePage(Model model) {
		return "single";
	}
	
	@RequestMapping("/team.html")
	public String TeamPage(Model model) {
		return "team";
	}
	
	@RequestMapping("/volunteer.html")
	public String VolunteerPage(Model model) {
		return "volunteer";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    repo.save(user);
	     
	    return "register_success";
	}
	
	@GetMapping("/blood")
	public String showRegistrationFormBlood(Model model) {
	    model.addAttribute("blood", new Blood());
	    return "blood";
	}
	
	@PostMapping("/process_blood")
	public String BloodRegister(Blood details) {
		
	    bloodrepo.save(details);
	     
	    return "blood_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<User> listUsers = repo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
}

