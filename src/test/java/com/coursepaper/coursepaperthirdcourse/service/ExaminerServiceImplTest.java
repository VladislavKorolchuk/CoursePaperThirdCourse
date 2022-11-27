package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.metods.Random;
import com.coursepaper.coursepaperthirdcourse.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExaminerServiceImplTest {

    Random random = new Random();
    private JavaQuestionService javaQuestionService = new JavaQuestionService(random);
    ExaminerServiceImpl examinerService = new ExaminerServiceImpl(javaQuestionService);

    @BeforeEach
    void setUp() {

        Question question = new Question("2*2=", "4");
        javaQuestionService.questionAdd(question);
        Question question1 = new Question("2*3=", "6");
        javaQuestionService.questionAdd(question1);
        Question question2 = new Question("2*4=", "8");
        javaQuestionService.questionAdd(question2);
        Question question3 = new Question("2*5=", "10");
        javaQuestionService.questionAdd(question3);
        Question question4 = new Question("2*6=", "12");
        javaQuestionService.questionAdd(question4);
    }

    @Test
    void getQuestions() {
        assertNotNull(javaQuestionService);
        assertNotNull(examinerService);
        assertEquals(examinerService.getQuestions(1).size(), 1);
        assertEquals(examinerService.getQuestions(3).size(), 3);
    }

}