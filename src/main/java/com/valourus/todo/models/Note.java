package com.valourus.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

    public Note() {}

    public Note(String text) {
        this.text = text;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String text;


    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
