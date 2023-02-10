package br.com.javaapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity //representa uma tabela no banco
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	//precison -> numero total de digitos
	//scale -> total de numeros dps da virgula
	//nullable = true -> campo opcional            false -> campo obrigatorio
	//unique = true -> não pode repetir            false -> pode repetir
	@Column(length = 50, nullable = false, unique = false)
	private String firstName;
	
	@Column(length = 50, nullable = false, unique = false)
	private String lastName;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 50, nullable = false, unique = false)
	private String password;
}
