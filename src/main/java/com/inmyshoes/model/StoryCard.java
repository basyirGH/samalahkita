package com.inmyshoes.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="story_card")
public class StoryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "relatedStoryCards")
    private Set<Circumstance> relatedCircumstances = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Circumstance> getRelatedCircumstances() {
        return relatedCircumstances;
    }

    public void setRelatedCircumstances(Set<Circumstance> relatedCircumstances) {
        this.relatedCircumstances = relatedCircumstances;
    }

    
}
