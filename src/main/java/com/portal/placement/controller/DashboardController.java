package com.portal.placement.controller;

import com.portal.placement.repository.DsaQuestionRepository;
import com.portal.placement.repository.AptitudeQuestionRepository;
import com.portal.placement.repository.UserDsaProgressRepository;
import com.portal.placement.service.DsaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private DsaQuestionRepository dsaQuestionRepository;

    @Autowired
    private AptitudeQuestionRepository aptitudeQuestionRepository;

    @Autowired
    private UserDsaProgressRepository progressRepository;

    @Autowired
    private DsaQuestionService dsaQuestionService;

    @GetMapping("/summary")
    public Map<String, Object> getSummary(@RequestParam String email) {
        Map<String, Object> summary = new HashMap<>();

        long totalDsa = dsaQuestionRepository.count();
        long completedDsa = progressRepository.countByUserEmailAndCompleted(email, true);
        long pendingDsa = totalDsa - completedDsa;
        double pct = totalDsa == 0 ? 0 : ((double) completedDsa / totalDsa) * 100;

        Map<String, Object> topicStats = new HashMap<>();
        String[] topics = {"Arrays","Strings","LinkedList","Trees","Dynamic Programming","Graphs"};
        for (String topic : topics) {
            long topicTotal = dsaQuestionRepository.findByTopic(topic).size();
            long topicDone = dsaQuestionService.getByTopicForUser(topic, email)
                    .stream().filter(q -> (Boolean) q.get("completed")).count();
            Map<String, Long> t = new HashMap<>();
            t.put("total", topicTotal);
            t.put("completed", topicDone);
            topicStats.put(topic, t);
        }

        summary.put("dsaTotal", totalDsa);
        summary.put("dsaCompleted", completedDsa);
        summary.put("dsaPending", pendingDsa);
        summary.put("dsaPercentage", String.format("%.1f", pct));
        summary.put("dsaTopicWise", topicStats);
        summary.put("aptitudeTotalQuestions", aptitudeQuestionRepository.count());
        return summary;
    }
}