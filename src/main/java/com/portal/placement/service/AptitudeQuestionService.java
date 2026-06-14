package com.portal.placement.service;

import com.portal.placement.model.AptitudeQuestion;
import com.portal.placement.repository.AptitudeQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AptitudeQuestionService {

    @Autowired
    private AptitudeQuestionRepository aptitudeQuestionRepository;

    // Get all questions
    public List<AptitudeQuestion> getAllQuestions() {
        return aptitudeQuestionRepository.findAll();
    }

    // Get by category
    public List<AptitudeQuestion> getByCategory(String category) {
        return aptitudeQuestionRepository.findByCategory(category);
    }

    // Submit answers and get score
    public String submitQuiz(Map<Long, String> userAnswers) {
        int correct = 0;
        int total = userAnswers.size();

        for (Map.Entry<Long, String> entry : userAnswers.entrySet()) {
            Long questionId = entry.getKey();
            String userAnswer = entry.getValue();

            AptitudeQuestion question = aptitudeQuestionRepository
                    .findById(questionId).orElse(null);

            if (question != null && 
                question.getCorrectAnswer().equalsIgnoreCase(userAnswer)) {
                correct++;
            }
        }
        double percentage = ((double) correct / total) * 100;
        return "Score: " + correct + "/" + total + 
               " (" + String.format("%.1f", percentage) + "%)";
    }
}