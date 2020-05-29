package de.neuefische.todoapp.service;

import de.neuefische.todoapp.db.ToDoDb;
import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static de.neuefische.todoapp.model.ToDoStatus.OPEN;

@Service
public class ToDoService {

    private ToDoDb toDoDb;
    private ToDoStatus toDoStatus = OPEN;


    public ToDoService(ToDoDb toDoDb) {
        this.toDoDb = toDoDb;
    }

    //Methoden
    public ArrayList<ToDo> getToDo() {
        return toDoDb.getToDo();
    }

    public ToDo addToDo(ToDo toDo) {
        toDo.setStatus(OPEN);
        toDo.setId(""+ UUID.randomUUID());
        return toDoDb.addToDo(toDo);

    }

    public ToDo switchToDo(String id){
        return  toDoDb.switchStatus(id);
    }

    public ToDo updateStatus(String id, ToDoStatus status) {
        return toDoDb.updateStatus(id,status);
    }

    //Returns ToDoStatus to fill IN
    public ToDoStatus getStatus() {
        return toDoStatus;
    }

    public ArrayList<ToDo> deleteItem(String id) {
        return toDoDb.deleteToDo(id);
    }



}
