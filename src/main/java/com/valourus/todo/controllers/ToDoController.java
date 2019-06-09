package com.valourus.todo.controllers;

import com.valourus.todo.models.Note;
import com.valourus.todo.repositories.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class ToDoController {

    private final NoteService service;

    @Autowired
    public ToDoController(NoteService service) {
        this.service = service;
    }

    @RequestMapping()
    public List<Note> getNotes() {
        return service.readAll();
    }

    @PostMapping()
    public Note createNote(@RequestBody Note note) {
        return service.create(note.getText());
    }

    @PutMapping()
    public ResponseEntity<?> updateNote(@RequestBody Note data) {
        Note note = service.update(data);
        if(note == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(note, HttpStatus.OK );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
