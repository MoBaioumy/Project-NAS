package com.example.moham.zaker.Classes;

import java.io.Serializable;

public class Word implements Serializable {
    private String name;
    private String translation;
    private Boolean isMemorized;
    private Integer quizNumber;

    /**
     * Default constructor
     * @param name
     * @param translation
     */
    public Word(String name, String translation) {
        this.name = name;
        this.translation = translation;
    }

    /**
     * Constructor with quizNumber as well
     * @param name
     * @param translation
     * @param quizNumber
     */
    public Word(String name, String translation, Integer quizNumber) {
        this.name = name;
        this.translation = translation;
        this.quizNumber = quizNumber;
    }

    // Setters and Getters
    public String getName() {
        return name;
    }

    public String getTranslation() {
        return translation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Boolean getMemorized() {
        return isMemorized;
    }

    public Integer getQuizNumber() {
        return quizNumber;
    }

    public void setMemorized(Boolean memorized) {
        isMemorized = memorized;
    }

    public void setQuizNumber(Integer quizNumber) {
        this.quizNumber = quizNumber;
    }
}
