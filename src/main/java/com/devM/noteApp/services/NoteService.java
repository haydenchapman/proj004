package com.devM.noteApp.services;

import com.devM.noteApp.dtos.NoteDTO;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    @Transactional
    void addNote(NoteDTO noteDTO, Long userId);

    @Transactional
    void deleteNoteById(Long noteId);

    @Transactional
    void updateNoteById(NoteDTO noteDTO);

    //Ask Robert about this streaming method
    List<NoteDTO> getAllNotesByUserId(Long userId);

    Optional<NoteDTO> getNoteById(Long noteId);
}
