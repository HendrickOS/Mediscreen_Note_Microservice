package com.project9.Mediscreen_Note_Microservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project9.Mediscreen_Note_Microservice.domain.Note;
import com.project9.Mediscreen_Note_Microservice.services.NoteService;

@RestController
public class NoteController {

	@Autowired
	NoteService noteService;

	@RequestMapping("/notes")
	public List<Note> notesList(String lastnameOfPatient) {
		return noteService.findByLastnameOfPatient(lastnameOfPatient);
	}

	@PostMapping("/notes/validate")
	public Note validate(@Valid Note note) {
		return noteService.save(note);
	}

	@GetMapping("/notes/update/{id}")
	public Note showUpdateForm(@PathVariable("id") String id, Model model) {
//	public Note showUpdateForm(@PathVariable("id") ObjectId id, Model model) {
		return noteService.findById(id);
	}

	@PostMapping("/notes/update/{id}")
	public Note updateNote(@PathVariable("id") String id, @Valid Note note, BindingResult result, Model model) {
//	public Note updateNote(@PathVariable("id") ObjectId id, @Valid Note note, BindingResult result, Model model) {
		return noteService.save(note);
	}

	@GetMapping("/notes/delete/{id}")
	public void deleteNote(@PathVariable("id") String id) {
//	public void deleteNote(@PathVariable("id") ObjectId id) {
		noteService.deleteById(id);
	}

}
