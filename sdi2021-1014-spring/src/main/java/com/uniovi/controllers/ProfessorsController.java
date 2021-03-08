package com.uniovi.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorsService;

@Controller
public class ProfessorsController {

	@Autowired
	private ProfessorsService profsService;
	
	@RequestMapping("/professor/list")
	public String getListado(Model model, Pageable pageable,
			@RequestParam(value = "", required = false) String searchText) {
		Page<Professor> profs = new PageImpl<Professor>(new LinkedList<Professor>());
		if (searchText != null && !searchText.isEmpty())
			profs = profsService.searchProfessorsByNameAndSurname(pageable, searchText);
		else
			profs = profsService.getProfessors(pageable);
		model.addAttribute("profsList", profs.getContent());
		model.addAttribute("page", profs);
		return "professor/list";
	}
	
	@RequestMapping("/professor/list/update")
	public String updateList(Model model) {
		model.addAttribute("profsList", profsService.getProfessors());
		return "professor/list :: tableProfessor";
	}
	
}
