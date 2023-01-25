package com.devM.noteApp.repositories;

import com.devM.noteApp.entites.Notes;
import com.devM.noteApp.entites.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotesRepository extends JpaRepository <Notes,Long>{

    List<Notes> findAllByUserEquals(User user);
}
