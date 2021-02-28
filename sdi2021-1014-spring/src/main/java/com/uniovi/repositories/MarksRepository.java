package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.uniovi.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.*;

public interface MarksRepository extends CrudRepository<Mark, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
	void updateResend(Boolean resend, Long id);

}
