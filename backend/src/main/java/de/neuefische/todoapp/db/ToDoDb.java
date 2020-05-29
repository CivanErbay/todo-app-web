package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoStatus;
import de.neuefische.todoapp.model.UpdateToDoStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static de.neuefische.todoapp.model.ToDoStatus.*;

@Data
@NoArgsConstructor
@Repository
public class ToDoDb {

    private ToDo toDo;

    ArrayList<ToDo> toDos = new ArrayList<>();

    public ToDoDb(ToDo toDo) {
        this.toDo = toDo;
    }

    //Method
    public ToDo addToDo(ToDo toDo) {
       toDos.add(toDo);
       return toDo;
    }

    public ArrayList<ToDo> getToDo() {
        return toDos;
    }


    //DIESE INFO (STATUS) BEFINDET SICH BEREITS IM FRONTEND WIRD BEI CLICK ÜBERLIEFERT -- Deswegen wird Methode updateStatus
    public ToDo switchStatus (String id) {
        for (int i = 0; i < toDos.size(); i++) {
            if (toDos.get(i).getId().equals(id)) {
                if (toDos.get(i).getStatus().equals(OPEN)) {
                    toDos.get(i).setStatus(IN_PROGRESS);
                    return toDos.get(i);
                }
                if (toDos.get(i).getStatus().equals(IN_PROGRESS)) {
                   toDos.get(i).setStatus(DONE);
                    return toDos.get(i);
                }
            }
        }
        return null;
    }

    public ToDo updateStatus (String id, ToDoStatus status) {
        for (ToDo aDo : toDos) {
            if (aDo.getId().equals(id)) {
                aDo.setStatus(status);
                return aDo;
            }
        }
        return null;
    }

    public ArrayList<ToDo> deleteToDo(String id) {
        for (int i = 0; i < toDos.size(); i++) {
            if(toDos.get(i).getId().equals(id)) {
                toDos.remove(toDos.get(i));
            }
        }
        return toDos;
    }



}
