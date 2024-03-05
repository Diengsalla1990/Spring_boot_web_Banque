package com.diengsalla.entities;



import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte{
	private Double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String codeCompte, Date dateCreation, Double solde, Client client, Double taux) {
		super(codeCompte, dateCreation, solde, client);
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	
	
	

}
