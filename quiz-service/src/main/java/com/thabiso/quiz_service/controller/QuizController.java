package com.thabiso.quiz_service.controller;

import com.thabiso.quiz_service.model.QuestionWrapper;
import com.thabiso.quiz_service.model.QuizDto;
import com.thabiso.quiz_service.model.Response;
import com.thabiso.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(
            @RequestBody QuizDto quizDto
    ) {
        return quizService.createQuiz(
                quizDto.getCategoryName(),
                quizDto.getNumQuestions(),
                quizDto.getTitle()
        );
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(
            @PathVariable Long id
    ) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(
            @PathVariable Long id,
            @RequestBody List<Response> responses
    ) {
        return quizService.calculateResult(responses);
    }

}
