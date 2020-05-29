package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoStatus;
import de.neuefische.todoapp.model.UpdateToDoStatus;
import de.neuefische.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public ArrayList<ToDo> GetToDo() {
        return toDoService.getToDo();
    }

    @PutMapping
    public ToDo addToDo(@RequestBody ToDo todo) {
    return toDoService.addToDo(todo);
    }

  /* //Meine eigene Methode - hat auch geklappt und bezieht sich auf switchStatus Methode in ToDoDb
    @PutMapping("{id}/status")
    public ToDo setStatus(@PathVariable String id, @RequestBody UpdateToDoStatus status)
    {
        return toDoService.switchToDo(id);
    }*/

    @PutMapping("{id}/status")
    public ToDo setStatus(@PathVariable String id, @RequestBody ToDo body)
    {
        return toDoService.updateStatus(id,body.getStatus());
    }

    @DeleteMapping("{id}")
        public ArrayList<ToDo> deleteToDo(@PathVariable String id) {
        return toDoService.deleteItem(id);
    }







}
