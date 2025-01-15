package com.thabiso.question_service.dao;

import com.thabiso.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);

    @Query(
            value = "SELECT q.id FROM Question q " +
                    "WHERE q.category = :category " +
                    "ORDER BY RANDOM() " +
                    "LIMIT :numQ",
            nativeQuery = true
    )
    List<Long> findRandomQuestionsByCategory(String category, int numQ);
}
