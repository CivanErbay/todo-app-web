package de.neuefische.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/*@NoArgsConstructor*/ // Nur setzen, wenn AllArgsCons, da sonst kein NoArgs mehr vorhanden

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    private String id;
    private String description;
    private ToDoStatus status;

}
