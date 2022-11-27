package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.metods.Random;
import com.coursepaper.coursepaperthirdcourse.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private Random random;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

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
        assertEquals(javaQuestionService.getAll().size(), 6);

    }

    @Test
    void testQuestionAdd() {
        Question question = new Question("9*9=", "81");
        javaQuestionService.questionAdd(question);
        assertEquals(javaQuestionService.getAll().size(), 6);
    }

    @Test
    void questionRemove() {
        Question question = new Question("9*9=", "81");
        assertEquals(javaQuestionService.getAll().size(), 5);
    }

    @Test
    void getAll() {
        assertEquals(javaQuestionService.getAll().size(), 5);
    }

    @Test
    void getRandomQuestion() {
        assertNotNull(random);
        Mockito.when(random.nextInt(anyInt())).thenReturn(3);
        assertEquals(javaQuestionService.getRandomQuestion().toString(), "Вопрос: 2*6= ответ: 12");
    }

    @Test
    void TestRandom() {
        Random random = new Random();
        int iCopy=0;
        int maxNumber=5;
        int numberOfCycles=100;

        for (int i = 0; i <= numberOfCycles; i++) {
            int meaning = random.nextInt(maxNumber);
            if (meaning < 0 || meaning > 5) {
                break;
            }
                 iCopy = i;
        }
        assertEquals(iCopy,numberOfCycles);
    }

}