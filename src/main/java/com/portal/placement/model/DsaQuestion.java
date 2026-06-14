package com.portal.placement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dsa_questions")
public class DsaQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private String title;
    private String difficulty;
    private String leetcode_url;
    private boolean completed;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getLeetcode_url() { return leetcode_url; }
    public void setLeetcode_url(String leetcode_url) { this.leetcode_url = leetcode_url; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}