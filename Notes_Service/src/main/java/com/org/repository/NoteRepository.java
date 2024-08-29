package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.dto.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{
}
