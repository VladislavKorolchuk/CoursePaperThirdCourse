package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.metods.Random;
import com.coursepaper.coursepaperthirdcourse.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questionsSet = new HashSet<>();

    private final Random random;

    public JavaQuestionService(Random random) {
        this.random = random;
    }

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
    public Question getRandomQuestion() {
        List<Question> questionsList = new ArrayList<>();

        int n = questionsSet.size();
        for (Question question : questionsSet) {
            questionsList.add(question);
        }
        return questionsList.get(random.nextInt(questionsSet.size()));
    }

}
