package com.coursepaper.coursepaperthirdcourse.controller;

import com.coursepaper.coursepaperthirdcourse.model.Question;
import com.coursepaper.coursepaperthirdcourse.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @PostMapping("/java/get")
    public Collection<Question> addQuestions1(@RequestParam("numberQuestion") int numberQuestion) {
        return examinerService.getQuestions(numberQuestion);
    }

}
