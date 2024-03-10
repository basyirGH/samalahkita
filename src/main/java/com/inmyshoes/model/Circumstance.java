package com.inmyshoes.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="circumstance")
public class Circumstance {

    public Circumstance() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "category", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'main'")
    private String category;

    // https://stackoverflow.com/questions/43054764/spring-rest-error-failed-to-load-resource-neterr-incomplete-chunked-encoding
    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "circumstance_and_story_card",
        joinColumns = @JoinColumn(name = "circumstance_id"),
        inverseJoinColumns = @JoinColumn(name = "story_card_id")
    )
    private Set<StoryCard> relatedStoryCards = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<StoryCard> getRelatedStoryCards() {
        return relatedStoryCards;
    }

    public void setRelatedStoryCards(Set<StoryCard> relatedStoryCards) {
        this.relatedStoryCards = relatedStoryCards;
    }

   
    


}
