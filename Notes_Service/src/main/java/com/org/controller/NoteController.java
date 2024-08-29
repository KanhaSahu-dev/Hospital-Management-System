package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.Note_dao;
import com.org.dto.Note;

@RestController
@RequestMapping("/note")
public class NoteController {
	@Autowired
	Note_dao NoteDao;
	
	@PostMapping
	public ResponseEntity<Note> saveNote(@RequestBody Note Note){
		return new ResponseEntity<Note>(NoteDao.saveNote(Note),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Note> fetchById(@PathVariable Integer id) {
		Note Note = NoteDao.fetchById(id);
		if(Note!=null)
			return new ResponseEntity<Note>(Note,HttpStatus.OK);
		else
			return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Note>> fetchAllNotes(){
		List<Note> fetchAllNotes = NoteDao.fetchAllNotes();
		if(fetchAllNotes!=null)
			return new ResponseEntity<List<Note>>(fetchAllNotes,HttpStatus.OK);
		else
			return new ResponseEntity<List<Note>>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeById(@PathVariable Integer id){
		String removeById = NoteDao.removeById(id);
		return new ResponseEntity<String>(removeById,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id,@RequestBody Note Note){
		NoteDao.updateNoteById(id, Note);
		return new ResponseEntity<String>("Updated successfully",HttpStatus.OK);
	}
}
