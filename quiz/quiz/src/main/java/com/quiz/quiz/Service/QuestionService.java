package com.quiz.quiz.Service;

import com.quiz.quiz.Entitiy.Question;
import com.quiz.quiz.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public Question saveQuestion(Question question){
        return questionRepo.save(question);
    }
}
