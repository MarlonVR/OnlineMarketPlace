package br.com.javaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javaapp.domain.User;

public interface UserRepository extends JpaRepository<User, Short>{

}
