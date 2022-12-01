package com.coursepaper.coursepaperthirdcourse.service;

import com.coursepaper.coursepaperthirdcourse.model.Question;

import java.util.Collection;
import java.util.Optional;

public interface ExaminerService {

    Collection<Optional<Question>> getQuestions(int amount);

}
