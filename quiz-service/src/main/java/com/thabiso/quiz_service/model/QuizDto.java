package com.thabiso.quiz_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class QuizDto {
    private String categoryName;
    private Integer numQuestions;
    private String title;
}
