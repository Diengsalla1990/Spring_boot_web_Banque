package com.diengsalla.services;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diengsalla.dao.CompteRepository;
import com.diengsalla.dao.OperationRepository;
import com.diengsalla.entities.Compte;
import com.diengsalla.entities.CompteCourant;
import com.diengsalla.entities.Operation;
import com.diengsalla.entities.Retrait;
import com.diengsalla.entities.Versement;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueService {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.findById(codeCpte).orElse(null);
		if(cp==null) throw new RuntimeException("Compte Introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
		
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse=0;
		
		if(cp instanceof CompteCourant) {
			facilitesCaisse=((CompteCourant) cp).getDecouvert();
		}
		if(cp.getSolde()+facilitesCaisse < montant) {
			throw new RuntimeException("Solde Insuffisant");
		}
		Retrait v = new Retrait(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		retirer(codeCpte2, montant);
		verser(codeCpte2, montant);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		
		return operationRepository.listoperration(codeCpte, PageRequest.of(page, size));
	}

}
