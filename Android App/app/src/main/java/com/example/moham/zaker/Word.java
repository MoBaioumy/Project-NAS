package com.example.moham.zaker;

import java.io.Serializable;

public class Word implements Serializable {
    private String name;
    private String translation;
    private Boolean isMemorized;
    private Integer quizNumber;

    public Word(String name, String translation) {
        this.name = name;
        this.translation = translation;
    }

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
