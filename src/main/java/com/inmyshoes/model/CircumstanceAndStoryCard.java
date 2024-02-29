package com.inmyshoes.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CircumstanceAndStoryCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "circumstanceId", nullable = false)
    private long circumstanceId;

    @Column(name = "storyCardId", nullable = false)
    private long storyCardId;
}
