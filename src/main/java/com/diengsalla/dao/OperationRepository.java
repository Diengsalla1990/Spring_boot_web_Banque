package com.diengsalla.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diengsalla.entities.Operation;

public interface OperationRepository extends CrudRepository<Operation, Long> {
	@Query("select o from Operation o Where o.compte.codeCompte=:x order by o.dateOperation desc" )
	public Page<Operation> listoperration(@Param("x")String codCpdte, Pageable pageable);

}
