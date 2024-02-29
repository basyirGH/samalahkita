package com.inmyshoes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="story_card")
public class StoryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "age", nullable = false)
    private String age;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "economicStatus", nullable = false)
    private String economicStatus;

    @Column(name = "selfDescription", nullable = false)
    private String selfDescription;

    // current state, feelings,  goals achieved, etc

    @Column(name = "emotionalStatus", nullable = false)
    private String emotionalStatus;

    @Column(name = "links", nullable = false)
    private String link;

 
}
