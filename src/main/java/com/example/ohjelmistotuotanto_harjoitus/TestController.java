package com.example.ohjelmistotuotanto_harjoitus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private NoteRepository noteRepository;

    // Hakee kaikki muistiinpanot tietokannasta
    @GetMapping("/")
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    // Tallentaa uuden muistiinpanon tietokantaan
    @PostMapping("/")
    public Note addNote(@RequestBody String content) {
        Note note = new Note();
        note.setContent(content);
        return noteRepository.save(note);
    }
}