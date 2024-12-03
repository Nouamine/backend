package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Publication {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPublication;
	private String contenuPublication;

	@ManyToOne
    private Admin admin;
}
