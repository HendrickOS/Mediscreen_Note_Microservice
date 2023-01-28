package com.project9.Mediscreen_Note_Microservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project9.Mediscreen_Note_Microservice.domain.Note;
import com.project9.Mediscreen_Note_Microservice.repositories.NoteRepository;
import com.project9.Mediscreen_Note_Microservice.services.NoteService;

@SpringBootTest
public class NoteServiceTest {

	@Autowired
	private NoteService noteServiceUnderTest;
	@MockBean
	private NoteRepository noteRepositoryMocked;

	@Test
	public void findNoteByLastnameOfPatient() {
		String givenLastnameOfPatient = "lastname";
		List<Note> expected = new ArrayList<Note>();

		when(noteRepositoryMocked.findByLastnameOfPatient(givenLastnameOfPatient)).thenReturn(expected);

		List<Note> result = noteServiceUnderTest.findByLastnameOfPatient(givenLastnameOfPatient);

		assertThat(result).isEqualTo(expected);
		verify(noteRepositoryMocked, times(1)).findByLastnameOfPatient(givenLastnameOfPatient);
	}

}
