package com.dxc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
	
	List<Note> findByAllCreatedBy(String createdBy);
	Note fingByNoteIdAndcreatedBy(Long noteId, String createdBy);
}
