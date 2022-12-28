package com.project9.Mediscreen_Note_Microservice.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project9.Mediscreen_Note_Microservice.domain.Note;
import com.project9.Mediscreen_Note_Microservice.repositories.NoteRepository;

@Component
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteRepository noteRepository;

	@Override
	public Note save(Note note) {
		return noteRepository.save(note);
	}

	@Override
	public List<Note> findAll() {
		List<Note> result = new ArrayList<>();
		Iterable<Note> findAll = noteRepository.findAll();
		for (Iterator<Note> iterator = findAll.iterator(); iterator.hasNext();) {
			result.add(iterator.next());
		}
		return result;
	}

	@Override
	public List<Note> findByPatientsName(String patientsName) {
		List<Note> findAll = noteRepository.findByPatientsName(patientsName);
		return findAll;
	}

	@Override
	public Note findById(Integer id) {
		return noteRepository.findById(id).get();
	}

	@Override
	public void delete(Note note) {
		noteRepository.delete(note);

	}

	@Override
	public List<String> commentariesOfEachNoteOfPatient(String patientsName) {
		List<Note> notes = findByPatientsName(patientsName);
		List<String> commentaries = new ArrayList<>();
		for (Note note : notes) {
			commentaries.add(note.getCommentary());
		}
		return commentaries;
	}

}
