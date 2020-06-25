package de.neuefische.todoapp.service;

import de.neuefische.todoapp.db.ToDoDb;
import de.neuefische.todoapp.db.ToDoMongoDb;
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
    private ToDoMongoDb toDoMongoDb;


    public ToDoService(ToDoDb toDoDb, ToDoMongoDb toDoMongoDb) {
        this.toDoDb = toDoDb;
        this.toDoMongoDb = toDoMongoDb;
    }


    //Methoden
    public List<ToDo> getToDo() {
        return (List<ToDo>) toDoMongoDb.findAll();
    }

    public ToDo addToDo(ToDo toDo) {
        toDo.setStatus(OPEN);
        toDo.setId(""+ UUID.randomUUID());
        return toDoMongoDb.save(toDo);

    }


    public ToDo updateStatus(String id, ToDoStatus status) {
        return toDoDb.updateStatus(id,status);
    }



    public ArrayList<ToDo> deleteItem(String id) {
        return toDoDb.deleteToDo(id); //with MongoDb .remove
    }



}
