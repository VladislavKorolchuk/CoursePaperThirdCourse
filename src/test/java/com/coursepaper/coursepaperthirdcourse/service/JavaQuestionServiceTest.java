package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService = new JavaQuestionService();

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
    void questionAdd() {
        javaQuestionService.questionAdd("9*9= ", "81");
        assertTrue(javaQuestionService.getAll().toString().contains("Вопрос: 9*9=  ответ: 81"));
        assertEquals(javaQuestionService.getAll().size(), 6);
    }

    @Test
    void testQuestionAdd() {
        Question question = new Question("9*9= ", "81");
        javaQuestionService.questionAdd(question);
        assertTrue(javaQuestionService.getAll().toString().contains("Вопрос: 9*9=  ответ: 81"));
        assertEquals(javaQuestionService.getAll().size(), 6);
    }

    @Test
    void questionRemove() {
        Question question = new Question("9*9=", "81");
        javaQuestionService.questionAdd(question);
        assertEquals(javaQuestionService.getAll().size(), 6);
        javaQuestionService.questionRemove(question);
        assertEquals(javaQuestionService.getAll().size(), 5);
        assertFalse(javaQuestionService.getAll().toString().contains("Вопрос: 9*9=  ответ: 81"));
    }

    @Test
    void getAll() {
        assertEquals(javaQuestionService.getAll().size(), 5);
        assertTrue(javaQuestionService.getAll().toString().contains("Вопрос: 2*3= ответ: 6"));
        assertTrue(javaQuestionService.getAll().toString().contains("Вопрос: 2*5= ответ: 10"));
        assertTrue(javaQuestionService.getAll().toString().contains("Вопрос: 2*2= ответ: 4"));
        assertTrue(javaQuestionService.getAll().toString().contains("Вопрос: 2*6= ответ: 12"));
        assertTrue(javaQuestionService.getAll().toString().contains("Вопрос: 2*4= ответ: 8"));
    }

    @Test
    void getRandomQuestion() {
        assertNotNull(javaQuestionService.getRandomQuestion());
    }

}