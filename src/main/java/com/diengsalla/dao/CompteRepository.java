package com.diengsalla.dao;


import org.springframework.data.repository.CrudRepository;

import com.diengsalla.entities.Compte;

public interface CompteRepository  extends CrudRepository<Compte, String> {

}
