package com.project9.Mediscreen_Note_Microservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.project9.Mediscreen_Note_Microservice.domain.Note;

public interface NoteRepository extends MongoRepository<Note, Integer>, CrudRepository<Note, Integer> {

	public List<Note> findByPatientsName(String patientsName);

	public Note save(Note note);

	public void deleteById(Integer id);

}
