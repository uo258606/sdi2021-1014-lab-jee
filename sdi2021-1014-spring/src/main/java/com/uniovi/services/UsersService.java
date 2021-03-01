package com.uniovi.services;

import java.util.*;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.uniovi.repositories.UsersRepository;
import org.springframework.data.domain.*;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostConstruct
	public void init() {
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}
	
	public Page<User> getUsers(Pageable pageable) {
		Page<User> users = usersRepository.findAll(pageable);
		return users;
	}

	public User getUser(Long id) {
		return usersRepository.findById(id).get();
	}

	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
	}

	public User getUserByDni(String dni) {
		return usersRepository.findByDni(dni);
	}

	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}

	public Page<User> searchUsersByNameAndSurname(Pageable pageable, String searchText) {
		Page<User> users =  new PageImpl<User>(new LinkedList<User>());
		searchText = "%" + searchText + "%";
		users = usersRepository.searchByNameAndSurname(pageable, searchText);

		return users;
	}

}