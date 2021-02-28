package com.uniovi.services;

import org.springframework.stereotype.Service;
import com.uniovi.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.uniovi.repositories.*;
import java.util.*;
import javax.servlet.http.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.*;

@Service
public class MarksService {

	@Autowired
	private MarksRepository marksRepository;

	@Autowired
	private HttpSession httpSession;

	public List<Mark> getMarks() {
		List<Mark> marks = new ArrayList<Mark>();
		marksRepository.findAll().forEach(marks::add);
		return marks;
	}

//	public Mark getMark(Long id) {
//		return marksRepository.findById(id).get();
//	}

	public void addMark(Mark mark) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		marksRepository.save(mark);
	}

	public void deleteMark(Long id) {
		marksRepository.deleteById(id);
	}

	public Mark getMark(Long id) {
		Set<Mark> consultedList = (Set<Mark>) httpSession.getAttribute("consultedList");
		if (consultedList == null) {
			consultedList = new HashSet<Mark>();
		}
		Mark obtainedmark = marksRepository.findById(id).get();
		consultedList.add(obtainedmark);
		httpSession.setAttribute("consultedList", consultedList);
		return obtainedmark;
	}

	public void setMarkResend(boolean revised, Long id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String dni = auth.getName();
		Mark mark = marksRepository.findById(id).get();
		if (mark.getUser().getDni().equals(dni)) {
			marksRepository.updateResend(revised, id);
		}

	}

	public List<Mark> getMarksForUser(User user) {
		List<Mark> marks = new ArrayList<Mark>();
		if (user.getRole().equals("ROLE_STUDENT")) {
			marks = marksRepository.findAllByUser(user);
		}
		if (user.getRole().equals("ROLE_PROFESSOR")) {
			marks = getMarks();
		}
		return marks;
	}

}
