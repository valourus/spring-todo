package com.valourus.todo.repositories;

import com.valourus.todo.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    public NoteRepository repo;

    public List<Note> readAll() {
        return repo.findAll();
    }

    public Note create(String text) {
        Note note = new Note(text);
        return repo.save(note);
    }

    public Note update(Note data)  {
        Optional<Note> result = repo.findById(data.getId());

        if(!result.isPresent()) return null;

        Note note = result.get();
        note.setText(data.getText());
        return repo.save(note);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
