package com.uniovi.services;

import org.springframework.stereotype.Service;
import com.uniovi.entities.Professor;
import java.util.*;
import javax.annotation.PostConstruct;

@Service
public class ProfessorService {

	private List<Professor> ProfessorsList = new LinkedList<Professor>();

	@PostConstruct
	public void init() {
		ProfessorsList.add(new Professor(1L, "12345678", "Víctor", "Suárez Sierra", "Informática"));
		ProfessorsList.add(new Professor(2L, "87654321", "Pepito", "Grillo", "Filosofía"));
	}

	public List<Professor> getProfessors() {
		return ProfessorsList;
	}

	public Professor getProfessor(Long id) {
		return ProfessorsList.stream().filter(Professor -> Professor.getId().equals(id)).findFirst().get();
	}

	public void addProfessor(Professor Professor) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		if (Professor.getId() == null) {
			Professor.setId(ProfessorsList.get(ProfessorsList.size() - 1).getId() + 1);
		}
		ProfessorsList.add(Professor);
	}

	public void deleteProfessor(Long id) {
		ProfessorsList.removeIf(Professor -> Professor.getId().equals(id));
	}

	public void editProfessor(Professor prof) {
		ProfessorsList.removeIf(Professor -> Professor.getId().equals(prof.getId()));
		ProfessorsList.add(prof);
		
	}

}