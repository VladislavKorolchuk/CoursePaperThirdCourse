package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
