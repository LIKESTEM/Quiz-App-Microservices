package com.thabiso.quiz_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;

    @ElementCollection
    private List<Long> questionIds;

    public Quiz() {
    }

    public Quiz(String title, List<Long> questionIds) {
        this.title = title;
        this.questionIds = questionIds;
    }
}
