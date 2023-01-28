package com.project9.Mediscreen_Note_Microservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project9.Mediscreen_Note_Microservice.domain.Note;

@Service
public interface NoteService {

	Note save(Note note);

	List<Note> findAll();

	List<Note> findByLastnameOfPatient(String lastnameOfPatient);

	Note findById(Integer id);

	void delete(Note note);

	List<String> commentariesOfEachNoteOfPatient(String lastnameOfPatient);

}
