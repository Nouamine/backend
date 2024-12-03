package com.example.demo.model;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy =InheritanceType.JOINED)
@DiscriminatorColumn(name="role",discriminatorType = DiscriminatorType.STRING)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;  //autoincrement
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	
}
