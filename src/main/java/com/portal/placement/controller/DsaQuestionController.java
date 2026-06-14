package com.portal.placement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.placement.service.DsaQuestionService;

@RestController
@RequestMapping("/api/dsa")
@CrossOrigin(origins = "*")
public class DsaQuestionController {

    @Autowired
    private DsaQuestionService dsaQuestionService;

    @GetMapping("/all")
    public List<Map<String, Object>> getAllQuestions(@RequestParam String email) {
        return dsaQuestionService.getAllQuestionsForUser(email);
    }

    @GetMapping("/topic/{topic}")
    public List<Map<String, Object>> getByTopic(
            @PathVariable String topic,
            @RequestParam String email) {
        return dsaQuestionService.getByTopicForUser(topic, email);
    }

    @PutMapping("/complete/{id}")
    public String markCompleted(
            @PathVariable Long id,
            @RequestParam String email) {
        return dsaQuestionService.markCompleted(id, email);
    }

    @GetMapping("/progress")
    public String getProgress(@RequestParam String email) {
        return dsaQuestionService.getProgress(email);
    }
}