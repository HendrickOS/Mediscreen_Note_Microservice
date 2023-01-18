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
	public List<Note> notesList(String patientsName) {
		return noteService.findByPatientsName(patientsName);
	}

//	@GetMapping("/notes/add")
//	public String addNote(Note note) {
//		return "note/add";
//	}

	@PostMapping("/notes/validate")
	public Note validate(@Valid Note note) {
//		if (!result.hasErrors()) {
		return noteService.save(note);
//			return "redirect:/notes/list";
//		}
//		return note;
	}

	@GetMapping("/notes/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Note note = noteService.findById(id);
		model.addAttribute("note", note);
		return "note/update";
	}

	@PostMapping("/notes/update/{id}")
	public String updateNote(@PathVariable("id") Integer id, @Valid Note note, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "note/update";
		}
		note.setId(id);
		noteService.save(note);
		model.addAttribute("note", noteService.findAll());
		return "redirect:/notes/list";
	}

	@GetMapping("/notes/delete/{id}")
	public String deleteNote(@PathVariable("id") Integer id, Model model) {
		Note note = noteService.findById(id);
		if (note != null) {
			noteService.delete(note);
		}
		model.addAttribute("note", noteService.findAll());
		return "redirect:/notes/list";
	}

}
