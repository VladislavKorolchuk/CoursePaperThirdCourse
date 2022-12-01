package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.exception.InvalidIndexException;
import com.coursepaper.coursepaperthirdcourse.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
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
        assertEquals(javaQuestionService.getAll().size(), 5);
        examinerService = new ExaminerServiceImpl(javaQuestionService);
        assertEquals(examinerService.getQuestions(2).size(),2);
        assertThrows(InvalidIndexException.class,()->examinerService.getQuestions(6));
    }

}