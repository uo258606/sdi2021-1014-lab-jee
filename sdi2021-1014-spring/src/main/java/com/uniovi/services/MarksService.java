package com.uniovi.services;

import org.springframework.stereotype.Service;
import com.uniovi.entities.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import com.uniovi.repositories.*;
import java.util.*;

@Service
public class MarksService {

	@Autowired
	private MarksRepository marksRepository;

	public List<Mark> getMarks() {
		List<Mark> marks = new ArrayList<Mark>();
		marksRepository.findAll().forEach(marks::add);
		return marks;
	}

	public Mark getMark(Long id) {
		return marksRepository.findById(id).get();
	}

	public void addMark(Mark mark) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		marksRepository.save(mark);
	}

	public void deleteMark(Long id) {
		marksRepository.deleteById(id);
	}

}
