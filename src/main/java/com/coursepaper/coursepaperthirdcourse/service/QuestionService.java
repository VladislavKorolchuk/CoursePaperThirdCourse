package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.model.Question;

import java.util.Collection;
import java.util.Optional;

public interface QuestionService {

    public Question questionAdd(String question, String answer);

    public Question questionAdd(Question question);

    public Question questionRemove(Question question);

    public Collection<Question> getAll();

    Optional<Question> getRandomQuestion();

}
