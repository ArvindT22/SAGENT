package com.quiz.quiz.Controller;


import com.quiz.quiz.Entitiy.Question;
import com.quiz.quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    public Question postQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }
}
