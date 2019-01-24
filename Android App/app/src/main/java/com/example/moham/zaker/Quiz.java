package com.example.moham.zaker;

import java.util.ArrayList;

public class Quiz {

    private String name;
    private ArrayList<Word> questions;
    private String description;

    /**
     * Default constructor
     * @param name
     * @param description
     */
    public Quiz(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor to add the questions as well
     * @param name
     * @param questions
     * @param description
     */
    public Quiz(String name, ArrayList<Word> questions, String description) {
        this.name = name;
        this.questions = questions;
        this.description = description;
    }

    // Setters and Getters
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
