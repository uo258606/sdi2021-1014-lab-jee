package com.uniovi.repositories;

import com.uniovi.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface UsersRepository extends CrudRepository<User, Long> {
	
	User findByDni(String dni);
	
	@Query("SELECT r FROM User r WHERE (LOWER(r.name) LIKE LOWER(?1) OR LOWER(r.lastName)LIKE LOWER(?1))")
	List<User> searchByNameAndSurname(String searchText);

}
