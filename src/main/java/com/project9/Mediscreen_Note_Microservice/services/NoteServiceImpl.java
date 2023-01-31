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
	public List<Note> findByLastnameOfPatient(String lastnameOfPatient) {
		return noteRepository.findByLastnameOfPatient(lastnameOfPatient);
	}

	@Override
	public Note findById(String id) {
		return noteRepository.findById(id).get();
//		return noteRepository.findById(id);
	}

	@Override
	public void delete(Note note) {
		noteRepository.delete(note);
	}

	@Override
	public void deleteById(String id) {
//	public void deleteById(ObjectId id) {
		noteRepository.deleteById(id);

	}

	@Override
	public List<String> commentariesOfEachNoteOfPatient(String lastnameOfPatient) {
		List<Note> notes = findByLastnameOfPatient(lastnameOfPatient);
		List<String> commentaries = new ArrayList<>();
		for (Note note : notes) {
			commentaries.add(note.getCommentary());
		}
		return commentaries;
	}

}
