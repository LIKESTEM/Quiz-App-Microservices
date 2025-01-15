package com.thabiso.question_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String category;
    @Column(name="difficultylevel")
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @Column(name="question_title")
    private String questionTitle;
    @Column(name="right_answer")
    private String rightAnswer;

    public Question() {
    }

    public Question(String category, String difficultyLevel,
                    String option1, String option2,
                    String option3, String option4,
                    String questionTitle, String rightAnswer) {
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.questionTitle = questionTitle;
        this.rightAnswer = rightAnswer;
    }
}
