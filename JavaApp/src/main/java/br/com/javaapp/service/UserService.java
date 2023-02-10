package br.com.javaapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaapp.domain.User;
import br.com.javaapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	public Optional<User> findById(Short id) {
		if((userRepository.findById(id)).isEmpty()) {
			throw new RuntimeException("Usuario nao encontrado");
		}
		return userRepository.findById(id);
	}
	
	
	public User post(User user) {
		try {
			return userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Email já existente!");
		}
	}
	
	public User deleteById(Short id) {
		
		if(userRepository.findById(id).isEmpty()) {
			throw new RuntimeException("Usuario nao encontrado");
		}
		
		Optional<User> deleted = userRepository.findById(id);
		userRepository.deleteById(id);
		return deleted.get();
	}
	
	public User edit(@RequestBody User user) {
		// o spring nao tem metodo put, entao se usa o proprio save
		// no caso vai ser necessario colocar no json o id, caso o id que for colocado
		// nao exista, vai ser feito um post. Entao nesse metodo vou tratar isso
		
		if(userRepository.findById(user.getId()).isEmpty()) {
			throw new RuntimeException("Usuario nao encontrado");
		}
		
		return userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		List <User> users = userRepository.findAll();
		
		for(int i = 0; i<users.size(); i++) {
			if(users.get(i).getEmail().equals(email)) {
				//System.out.println(users.get(i).getEmail());
				return users.get(i);
			}
		}
	
		return null;
	}
}
