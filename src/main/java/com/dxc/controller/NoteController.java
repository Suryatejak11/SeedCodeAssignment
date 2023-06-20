package com.dxc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Note;
import com.dxc.repository.NoteRepository;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
	@Autowired
	private NoteRepository noteRepository;
	
	@PostMapping
	public Note createdNote(@RequestBody Note note) {
		note.setCreatedAt(new Date());
		return noteRepository.save(note);		
	}
	
	@PutMapping("/{noteId}")
	public Note updateNote(@PathVariable Long noteId, @RequestBody Note note) {
		Note existingNote = noteRepository.findById(noteId).orElse(null);
		if (existingNote != null) {
			existingNote.setNoteTitle(note.getNoteTitle());
			existingNote.setNoteContent(note.getNoteContent());
			existingNote.setNoteStatus(note.getNoteStatus());
			return noteRepository.save(existingNote);
		}
		return null;
	}

}
