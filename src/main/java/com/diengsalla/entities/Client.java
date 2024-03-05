package com.diengsalla.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	
	@Id @GeneratedValue
	private Long code;
	private String nom;
	private String email;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> compte;
	
	
	public Client( String nom, String email) {
		super();
		
		this.nom = nom;
		this.email = email;
		
	}


	public Client() {
		super();
	}


	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Compte> getCompte() {
		return compte;
	}


	public void setCompte(Collection<Compte> compte) {
		this.compte = compte;
	}

	
	
	
}
