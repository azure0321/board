package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.board.model.BBoard;

@Repository
public interface BBoardRepository extends JpaRepository<BBoard, Integer> {
    // List<BBoard> findByTitle(String title);
    // List<BBoard> findByContent(String content);
}