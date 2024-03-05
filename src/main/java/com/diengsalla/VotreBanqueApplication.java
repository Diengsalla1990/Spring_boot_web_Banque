package com.diengsalla;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.diengsalla.dao.ClientRepository;
import com.diengsalla.dao.CompteRepository;
import com.diengsalla.dao.OperationRepository;
import com.diengsalla.entities.Client;
import com.diengsalla.entities.Compte;
import com.diengsalla.entities.CompteCourant;
import com.diengsalla.entities.CompteEpargne;
import com.diengsalla.entities.Retrait;
import com.diengsalla.entities.Versement;
import com.diengsalla.services.IBanqueService;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository ;
	
	@Autowired
	private IBanqueService banqueService;
	
	public static void main(String[] args) {
	   SpringApplication.run(VotreBanqueApplication.class, args);
	   
	  
	}

	
	
	 @Override public void run(String... args) throws Exception {
		 
		/* Client c1 = clientRepository.save(new
				 Client("Ibra","papedieng30@gmail.com")); Client c2 =clientRepository.save(new
				 Client("Maiwen","maiwen.vourch@laposte.net"));
				 
				 Compte cp1 = compteRepository.save(new CompteCourant("c1",new Date(),
				 90000.0, c1, 6000.0));
				 
				 Compte cp2 = compteRepository.save(new CompteEpargne("c2", new Date(),
				 6000.0, c2, 5.5));
				 
				 operationRepository.save(new Versement(new Date(), 2300.0, cp1));
				 operationRepository.save(new Versement(new Date(), 6000.0, cp1));
				 operationRepository.save(new Versement(new Date(), 2300.0, cp1));
				 operationRepository.save(new Retrait(new Date(), 9000.0, cp1));
				 
				 operationRepository.save(new Versement(new Date(), 2300.0, cp2));
				 operationRepository.save(new Versement(new Date(), 6000.0, cp2));
				 operationRepository.save(new Versement(new Date(), 2300.0, cp2));
				 operationRepository.save(new Retrait(new Date(), 9000.0, cp2));
				 
				 banqueService.verser("c1", 111111.0);*/
				 
	 }
	 
	
	 
	 
	 

}
