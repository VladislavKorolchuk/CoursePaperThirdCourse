package com.coursepaper.coursepaperthirdcourse.controller;

import com.coursepaper.coursepaperthirdcourse.model.Question;
import com.coursepaper.coursepaperthirdcourse.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/exam")
public class ExamController {

    ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @PostMapping("/java/get")
    // С @GetMapping выдает 405 ошибку я, оставил как есть, т.к. не понимаю что еще надо поменять.
    public Collection<Optional<Question>> addQuestions1(@RequestParam("numberQuestion") int numberQuestion) {
        return examinerService.getQuestions(numberQuestion);
    }

}
