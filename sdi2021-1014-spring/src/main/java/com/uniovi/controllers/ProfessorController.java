package com.uniovi.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.uniovi.entities.*;
import com.uniovi.services.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ProfessorController {

	@Autowired // Inyectar el servicio
	private ProfessorService profService;

	@RequestMapping("/professor/list")
	public String getList() {
		return profService.getProfessors().toString();
	}

	@RequestMapping(value = "/professor/add", method = RequestMethod.POST)
	public String setProf(@ModelAttribute Professor prof) {
		profService.addProfessor(prof);
		return "Ok";
	}

	@RequestMapping("/professor/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return profService.getProfessor(id).toString();
	}

	@RequestMapping("/professor/delete/{id}")
	public String deleteProf(@PathVariable Long id) {
		profService.deleteProfessor(id);
		return "Ok";
	}

	@RequestMapping(value = "/professor/edit/{id}", method = RequestMethod.POST)
	public String getEdit(@ModelAttribute Professor prof) {
		profService.editProfessor(prof);
		return "Ok";
	}
}