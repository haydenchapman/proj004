package com.devM.noteApp.dtos;

import com.devM.noteApp.entites.Notes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO implements Serializable {
    private Long id;
    private String body;
    private UserDto userDto;

    public NoteDTO(Notes notes){
        if (notes.getId() != null){
            this.id = notes.getId();
        }
        if (notes.getBody() != null){
            this.body = notes.getBody();
        }
    }
}
