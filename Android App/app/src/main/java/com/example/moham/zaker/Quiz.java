package com.example.moham.zaker;

import java.util.ArrayList;

public class Quiz {

    private String name;
    private ArrayList<Word> questions;
    private String description;

    public Quiz(String name, ArrayList<Word> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Quiz(String name, ArrayList<Word> questions, String description) {
        this.name = name;
        this.questions = questions;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Word> getQuestions() {
        return questions;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(ArrayList<Word> questions) {
        this.questions = questions;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
