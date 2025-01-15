package com.thabiso.quiz_service.service;

import com.thabiso.quiz_service.dao.QuizDao;
import com.thabiso.quiz_service.feign.QuizInterface;
import com.thabiso.quiz_service.model.QuestionWrapper;
import com.thabiso.quiz_service.model.Quiz;
import com.thabiso.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(
            String category,
            int numQ,
            String title
    ) {
         List<Long> questions = quizInterface
                 .getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Long> questionIds = quiz.getQuestionIds();

        return quizInterface.getQuestionsFromId(questionIds);
    }

    public ResponseEntity<Integer> calculateResult(
            List<Response> responses
    ) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}
