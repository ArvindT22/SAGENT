package com.quiz.quiz.Repository;

import com.quiz.quiz.Entitiy.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
