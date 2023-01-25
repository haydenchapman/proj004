package com.devM.noteApp.services;

import com.devM.noteApp.dtos.NoteDTO;
import com.devM.noteApp.entites.Notes;
import com.devM.noteApp.entites.User;
import com.devM.noteApp.repositories.NotesRepository;
import com.devM.noteApp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotesRepository notesRepository;

    @Transactional
    public void addNote(NoteDTO noteDTO, Long userId){
        Optional<User> userOptional = userRepository.findByUsername(String.valueOf(userId));
        Notes note = new Notes(noteDTO);
        userOptional.ifPresent(note::setUser);
        notesRepository.saveAndFlush(note);
    }
    @Transactional
    public void deleteNoteById(Long noteId){
        Optional <Notes> notesOptional = notesRepository.findById(noteId);
        notesOptional.ifPresent(notes -> notesRepository.delete(notes));
    }
    @Transactional
    public void updateNoteById(NoteDTO noteDTO){
        Optional<Notes> notesOptional = notesRepository.findById(noteDTO.getId());
        notesOptional.ifPresent(notes -> {
            notes.setBody(noteDTO.getBody());
            notesRepository.saveAndFlush(notes);
        });
    }

    //Ask Robert about this streaming method
    public List<NoteDTO> getAllNotesByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Notes> notesList = notesRepository.findAllByUserEquals(userOptional.get());
            return notesList.stream().map(notes -> new NoteDTO(notes)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public Optional<NoteDTO> getNoteById(Long noteId){
        Optional<Notes> notesOptional = notesRepository.findById(noteId);
        if (notesOptional.isPresent()){
            new NoteDTO(notesOptional.get());
        }
        return Optional.empty();
    }
}
