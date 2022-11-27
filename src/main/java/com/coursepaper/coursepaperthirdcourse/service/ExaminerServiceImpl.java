package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.exception.InvalidIndexException;
import com.coursepaper.coursepaperthirdcourse.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount > javaQuestionService.getAll().size()) {
            throw new InvalidIndexException();
        }
        Set<Question> questionHashSet = new HashSet<>();
        while (questionHashSet.size() < amount) {
            questionHashSet.add(javaQuestionService.getRandomQuestion());
        }
        return questionHashSet;
    }

}
