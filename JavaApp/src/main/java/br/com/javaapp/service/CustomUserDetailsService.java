package br.com.javaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.javaapp.domain.User;
import br.com.javaapp.repository.UserRepository;
import br.com.javaapp.security.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
				
		if(user == null) {
			throw new UsernameNotFoundException("Email nao encontrado");
		}
		
		return new CustomUserDetails(user);
	}

}
