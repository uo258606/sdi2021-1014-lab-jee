package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;
import com.uniovi.repositories.ProfessorsRepository;

@Service
public class ProfessorsService {

	@Autowired
	private ProfessorsRepository ProfessorsRepository;

	@PostConstruct
	public void init() {
	}

	public List<Professor> getProfessors() {
		List<Professor> Professors = new ArrayList<Professor>();
		ProfessorsRepository.findAll().forEach(Professors::add);
		return Professors;
	}
	
	public Page<Professor> getProfessors(Pageable pageable) {
		Page<Professor> Professors = ProfessorsRepository.findAll(pageable);
		return Professors;
	}

	public Professor getProfessor(Long id) {
		return ProfessorsRepository.findById(id).get();
	}

	public void addProfessor(Professor Professor) {
		ProfessorsRepository.save(Professor);
	}

	public Professor getProfessorByDni(String dni) {
		return ProfessorsRepository.findByDni(dni);
	}

	public void deleteProfessor(Long id) {
		ProfessorsRepository.deleteById(id);
	}

	public Page<Professor> searchProfessorsByNameAndSurname(Pageable pageable, String searchText) {
		Page<Professor> Professors =  new PageImpl<Professor>(new LinkedList<Professor>());
		searchText = "%" + searchText + "%";
		Professors = ProfessorsRepository.searchByNameAndSurname(pageable, searchText);

		return Professors;
	}
	
}
