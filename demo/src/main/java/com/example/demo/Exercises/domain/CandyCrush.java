package com.example.demo.Exercises.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CandyCrush {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String inputSequence;

    private String outputSequence;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputSequence() {
        return this.inputSequence;
    }

    public void setInputSequence(String inputSequence) {
        this.inputSequence = inputSequence;
    }

    public String getOutputSequence() {
        return this.outputSequence;
    }

    public void setOutputSequence(String outputSequence) {
        this.outputSequence = outputSequence;
    }
}
