package com.project9.Mediscreen_Note_Microservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.project9.Mediscreen_Note_Microservice.domain.Note;

public interface NoteRepository extends MongoRepository<Note, Integer>, CrudRepository<Note, Integer> {

	public List<Note> findByLastnameOfPatient(String lastnameOfPatient);

//	Optional<Note> findById(ObjectId id);
//	Note findById(ObjectId id);
	Optional<Note> findById(String id);

	public Note save(Note note);

//	public void deleteById(ObjectId id);
	public void deleteById(String id);

}
