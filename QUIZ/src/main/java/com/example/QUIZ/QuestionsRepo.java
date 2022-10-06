package com.example.QUIZ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Integer> {

}