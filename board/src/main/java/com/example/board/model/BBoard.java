package com.example.board.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BBoard {
    @Id
    private int seq;
    private String title;
    private String content;
}
