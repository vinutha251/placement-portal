package com.portal.placement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.placement.model.UserDsaProgress;

@Repository
public interface UserDsaProgressRepository extends JpaRepository<UserDsaProgress, Long> {
    List<UserDsaProgress> findByUserEmail(String userEmail);
    Optional<UserDsaProgress> findByUserEmailAndQuestionId(String userEmail, Long questionId);
    long countByUserEmailAndCompleted(String userEmail, boolean completed);
}