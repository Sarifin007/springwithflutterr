package com.example.Springwithflutter.restcontroller;

import com.example.Springwithflutter.model.Tastitem;
import com.example.Springwithflutter.repository.ITaskitemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TeaskItemController {
    @Autowired
    ITaskitemRepo repo;

    @GetMapping("/alltask")
    public List<Tastitem> gettask(){
        return repo.findAll();
    }
    @PostMapping("/addtask")
    public  Tastitem addtask(@RequestBody Tastitem t){
        return repo.save(t);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTask(@PathVariable("id")Long id ){
        boolean exist=repo.existsById(id);
        if(exist){
            Tastitem tastitem=repo.getById(id);
            boolean done=tastitem.isDone();
            tastitem.setDone(!done);
            repo.save(tastitem);
            return new ResponseEntity<>("Task is Exist", HttpStatus.OK);

        }
        return new ResponseEntity<>("Task is not Exist",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity daleteTask(@PathVariable("id")Long id){

        boolean exist=repo.existsById(id);
        if(exist){
           repo.deleteById(id);
            return new ResponseEntity<>("Task is Exist", HttpStatus.OK);
        }
        return new ResponseEntity<>("Task is not Exist",HttpStatus.BAD_REQUEST);

    }

}

