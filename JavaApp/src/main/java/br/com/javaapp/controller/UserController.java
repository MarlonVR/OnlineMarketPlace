package br.com.javaapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaapp.domain.User;
import br.com.javaapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> get(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<User> get(@PathVariable Short id){
		return userService.findById(id);
	}
	
	
	@PostMapping         //@RequestBody se usa para enviar um JSON
	public User post(@RequestBody User user) {
		return userService.post(user);
	}
	
	/*@PathVariable vai servir para que no link da pagina "/{id}" seja passado o parametro id
	lembrando q o q estiver dentro do "/{variavel}" tem que ser o msm nome do parametro
	da função. No meu caso o parametro é id, entao no link fica "/{id}"*/
	@DeleteMapping("/{id}")
	public User delete(@PathVariable Short id) {
		return userService.deleteById(id);
	}
	
	@PutMapping
	public User put(@RequestBody User user) {
		return userService.edit(user);
	}
	// ainda nao consegui verificar o email
	@GetMapping("/verify-email")
	public String verifyEmail(@RequestParam String email) {
		return userService.findByEmail(email).get().getEmail();
	}
}
