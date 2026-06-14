package com.portal.placement.repository;

import com.portal.placement.model.DsaQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DsaQuestionRepository extends JpaRepository<DsaQuestion, Long> {
    
    // Get all questions by topic
    List<DsaQuestion> findByTopic(String topic);
    
    // Get all completed questions
    List<DsaQuestion> findByCompleted(boolean completed);
    
    // Get questions by topic and difficulty
    List<DsaQuestion> findByTopicAndDifficulty(String topic, String difficulty);
    
    // Count completed questions
    long countByCompleted(boolean completed);
}
