package com.portal.placement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.placement.model.AptitudeQuestion;
import com.portal.placement.service.AptitudeQuestionService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class AptitudeQuestionController {

    @Autowired
    private AptitudeQuestionService aptitudeQuestionService;

    // Get all questions
    @GetMapping("/all")
    public List<AptitudeQuestion> getAllQuestions() {
        return aptitudeQuestionService.getAllQuestions();
    }

    // Get by category
    @GetMapping("/category/{category}")
    public List<AptitudeQuestion> getByCategory(@PathVariable String category) {
        return aptitudeQuestionService.getByCategory(category);
    }

    // Submit quiz answers
    @PostMapping("/submit")
    public String submitQuiz(@RequestBody Map<Long, String> userAnswers) {
        return aptitudeQuestionService.submitQuiz(userAnswers);
    }
}
