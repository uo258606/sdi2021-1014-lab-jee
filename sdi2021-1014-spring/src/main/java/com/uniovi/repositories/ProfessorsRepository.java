package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Professor;

public interface ProfessorsRepository extends CrudRepository<Professor, Long> {

	Professor findByDni(String dni);

	@Query("SELECT r FROM Professor r WHERE (LOWER(r.name) LIKE LOWER(?1) OR LOWER(r.surname)LIKE LOWER(?1))")
	Page<Professor> searchByNameAndSurname(Pageable pageable, String searchText);

	Page<Professor> findAll(Pageable pageable);
}
