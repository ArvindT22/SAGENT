package com.quiz.quiz.Entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "QUESTION")
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @Column(name = "QUESTIONID")
    @GeneratedValue
    private int QuestionId;

    @Column(name = "CATEGORY")
    private String Category;

    @Column(name = "QUESTION")
    private String Question;

    @Column(name = "OPTIONONE")
    private String OptionOne;

    @Column(name = "OPTIONTWO")
    private String OptionTwo;

    @Column(name = "OPTIONTHREE")
    private String OptionThree;

    @Column(name = "OPTIONFOUR")
    private String OptionFour;

    @Column(name = "CORRECTOPTION")
    private String CorrectOption;

}
