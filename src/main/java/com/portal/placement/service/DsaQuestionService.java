package com.portal.placement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.placement.model.DsaQuestion;
import com.portal.placement.model.UserDsaProgress;
import com.portal.placement.repository.DsaQuestionRepository;
import com.portal.placement.repository.UserDsaProgressRepository;

@Service
public class DsaQuestionService {

    @Autowired
    private DsaQuestionRepository dsaQuestionRepository;

    @Autowired
    private UserDsaProgressRepository progressRepository;

    // Get all questions with user's completion status
    public List<Map<String, Object>> getAllQuestionsForUser(String userEmail) {
        List<DsaQuestion> questions = dsaQuestionRepository.findAll();
        return buildResponse(questions, userEmail);
    }

    // Get by topic with user's completion status
    public List<Map<String, Object>> getByTopicForUser(String topic, String userEmail) {
        List<DsaQuestion> questions = dsaQuestionRepository.findByTopic(topic);
        return buildResponse(questions, userEmail);
    }

    // Build response with user-specific completion
    private List<Map<String, Object>> buildResponse(List<DsaQuestion> questions, String userEmail) {
        List<UserDsaProgress> progressList = progressRepository.findByUserEmail(userEmail);
        Set<Long> completedIds = new HashSet<>();
        for (UserDsaProgress p : progressList) {
            if (p.isCompleted()) completedIds.add(p.getQuestionId());
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for (DsaQuestion q : questions) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", q.getId());
            map.put("topic", q.getTopic());
            map.put("title", q.getTitle());
            map.put("difficulty", q.getDifficulty());
            map.put("leetcodeUrl", q.getLeetcode_url());
            map.put("completed", completedIds.contains(q.getId()));
            result.add(map);
        }
        return result;
    }

    // Mark as completed for specific user
    public String markCompleted(Long questionId, String userEmail) {
        Optional<UserDsaProgress> existing = progressRepository
                .findByUserEmailAndQuestionId(userEmail, questionId);

        UserDsaProgress progress;
        if (existing.isPresent()) {
            progress = existing.get();
        } else {
            progress = new UserDsaProgress();
            progress.setUserEmail(userEmail);
            progress.setQuestionId(questionId);
        }
        progress.setCompleted(true);
        progressRepository.save(progress);
        return "Marked as completed!";
    }

    // Get progress for user
    public String getProgress(String userEmail) {
        long total = dsaQuestionRepository.count();
        long completed = progressRepository.countByUserEmailAndCompleted(userEmail, true);
        double pct = total == 0 ? 0 : ((double) completed / total) * 100;
        return completed + "/" + total + " completed (" + String.format("%.1f", pct) + "%)";
    }

    // For dashboard
    public long countCompletedForUser(String userEmail) {
        return progressRepository.countByUserEmailAndCompleted(userEmail, true);
    }

    public List<DsaQuestion> getByTopic(String topic) {
        return dsaQuestionRepository.findByTopic(topic);
    }
}