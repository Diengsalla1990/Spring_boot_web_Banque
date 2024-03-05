package com.diengsalla.entities;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable {
	
	@Id 
	private String codeCompte;
	private Date dateCreation;
	private Double solde;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	@OneToMany(mappedBy = "compte",fetch=FetchType.LAZY)
	private Collection<Operation> operation;
	
	public Compte() {
		super();
	}

	public Compte(String codeCompte, Date dateCreation, Double solde, Client client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Operation> getOperation() {
		return operation;
	}

	public void setOperation(Collection<Operation> operation) {
		this.operation = operation;
	}
	
	

}
