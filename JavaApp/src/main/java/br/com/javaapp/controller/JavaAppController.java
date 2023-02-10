package br.com.javaapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.javaapp.domain.User;
import br.com.javaapp.service.UserService;


@RestController
@RequestMapping("")
public class JavaAppController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public ModelAndView signUp(Model model) {
		model.addAttribute("user", new User());
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("SignUp");
	    return modelAndView;
    }
	
	@PostMapping("/signup_process")
	public ModelAndView signupProcess(User user, @RequestParam("confirmarSenha") String confirmPassword) {
		
		if(!user.getPassword().equals(confirmPassword)) {
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("SignUp");
		    modelAndView.addObject("errorMessage", "Senhas não coincidem.");
		    return modelAndView;
		}
		
		userService.post(user);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("SignUpSuccess");
	    return modelAndView;
	}
	
	
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("Home");
	    return modelAndView;
    } 
}
