package com.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.dto.Note;
import com.org.repository.NoteRepository;

@Repository
public class Note_dao {
	@Autowired
	NoteRepository repo;
	
	public Note saveNote(Note Note) {
		return repo.save(Note);
	}
	
	public Note fetchById(int id) {
		return repo.findById(id).orElse(null);		
	}
	
	public List<Note> fetchAllNotes(){
		return repo.findAll();
	}
	
	public String removeById(int id) {
		repo.deleteById(id);
		
		return "Note removed";
	}
	
	public Note updateNoteById(int id , Note Note) {
		if(repo.findById(id)!=null) {
			repo.save(Note);
			return repo.findById(id).orElse(null);
		}
		return null;
	}
}
