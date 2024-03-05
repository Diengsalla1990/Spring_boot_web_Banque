package com.diengsalla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.diengsalla.entities.Compte;
import com.diengsalla.entities.Operation;
import com.diengsalla.services.IBanqueService;

@Controller
public class BanqueController {
	
	@Autowired
	private IBanqueService banqueService;
	
	@GetMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	@GetMapping("/consultercompte")
	public String consulter(Model model, String codeCompte) {
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cp = banqueService.consulterCompte(codeCompte);
			Page<Operation> pageoperations = banqueService.listOperation(codeCompte, 0, 4);
			model.addAttribute("listOperations", pageoperations.getContent());
			model.addAttribute("compte", cp);
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}
		
		return "comptes";
	}
	

}
