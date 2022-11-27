package com.coursepaper.coursepaperthirdcourse.controller;

import com.coursepaper.coursepaperthirdcourse.model.Question;
import com.coursepaper.coursepaperthirdcourse.service.ExaminerServiceImpl;
import com.coursepaper.coursepaperthirdcourse.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService, ExaminerServiceImpl examinerService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java")
    public Collection getAllQuestions() {
        return javaQuestionService.getAll();
    }

    @PostMapping("/java/add")
    public Question addQuestions(@RequestBody Question question) {
        return javaQuestionService.questionAdd(question);
    }

    @PutMapping("/java/add")
    public Question addQuestions(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return javaQuestionService.questionAdd(question, answer);
    }

    @DeleteMapping("/java/remove")
    public Question deleteQuestions(@RequestBody Question question) {
        return javaQuestionService.questionRemove(question);
    }

}
