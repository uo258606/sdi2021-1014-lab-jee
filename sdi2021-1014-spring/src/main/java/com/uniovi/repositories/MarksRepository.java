package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.uniovi.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface MarksRepository extends CrudRepository<Mark, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
	void updateResend(Boolean resend, Long id);
	
	Page<Mark> findAll(Pageable pageable);
	
	@Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC ")
	Page<Mark> findAllByUser(Pageable pageable, User user);
	
	@Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name)LIKE LOWER(?1))")
	Page<Mark> searchByDescriptionAndName(Pageable pageable, String searchText);
	
	@Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name)LIKE LOWER(?1)) AND r.user = ?2 ")
	Page<Mark> searchByDescriptionNameAndUser(Pageable pageable, String searchText, User user);

}
