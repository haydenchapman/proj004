package com.devM.noteApp.controllers;

import com.devM.noteApp.dtos.NoteDTO;
import com.devM.noteApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//note control
@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    //get all notes by a user
    @GetMapping("/user/{userId}")
    public List<NoteDTO> getNotesByUser(@PathVariable Long userId){
        return noteService.getAllNotesByUserId(userId);
    }

    //add a note
    @PostMapping("/user/{userId}")
    public void addNote(@RequestBody NoteDTO noteDTO, @PathVariable Long userId){
        noteService.addNote(noteDTO, userId);
    }

    //delete note
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId){
        noteService.deleteNoteById(noteId);
    }

    //update existing note
    @PutMapping("/{noteId}")
    public void updateNoteById(@RequestBody NoteDTO noteDTO){
        noteService.updateNoteById(noteDTO);
    }

    //get individual note
    @GetMapping("/{noteId}")
    public void getNoteById(@PathVariable Long noteId){
        noteService.getNoteById(noteId);
    }
}
//backend complete