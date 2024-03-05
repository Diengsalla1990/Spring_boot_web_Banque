package com.diengsalla.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.diengsalla.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
