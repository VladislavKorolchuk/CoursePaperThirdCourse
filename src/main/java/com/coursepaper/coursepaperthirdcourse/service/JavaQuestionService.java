package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.model.Question;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questionsSet = new HashSet<>();

    Random random = new Random();

    @Override
    public Question questionAdd(String question, String answer) {
        Question questionObject = new Question(question, answer);
        questionsSet.add(questionObject);
        return questionObject;
    }

    @Override
    public Question questionAdd(Question question) {
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question questionRemove(Question question) {
        Question questionCopy = question;
        questionsSet.remove(question);
        return questionCopy;
    }

    @Override
    public Collection<Question> getAll() {
        return questionsSet;
    }

    @Override
    public Optional<Question> getRandomQuestion() {

        return questionsSet.stream()
                .skip(random.nextInt(questionsSet.size()))
                .findFirst();

    }

}
