package com.gambira.inventory.controller;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import com.gambira.inventory.models.Mdl_users;
import com.gambira.inventory.repository.Repo_users;

@Controller
public class AuthController {
	
	@Autowired
	Repo_users repoUsers;

    @GetMapping("/login")
    public String loginPage(Model model) {
    	model.addAttribute("user", new Mdl_users());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(Mdl_users user, Model model, HttpSession session, RedirectAttributes redirectAttribute) {
    	Mdl_users userData = repoUsers.getUser(user.getUsername(), user.getPassword());
    	if(userData != null) {
    		session.setAttribute("loggedInUser", user.getUsername());
    		return "redirect:/dashboard";
    	}else {
    		redirectAttribute.addFlashAttribute("error", "Enter correct Username and password");
            return "redirect:/login";
    	}
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
    	model.addAttribute("user", new Mdl_users());
        return "register";
    }
    @PostMapping("/register/save")
    public String registerSave(Mdl_users data) {
    	repoUsers.save(data);
    	return"redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // ✅ clears all session attributes
        return "redirect:/login"; // back to login page
    }
}
