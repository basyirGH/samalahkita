package com.inmyshoes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmyshoes.model.Circumstance;
import com.inmyshoes.model.StoryCard;
import com.inmyshoes.repository.CircumstanceRepository;
import com.inmyshoes.repository.StoryCardRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StoryCardService {

    @Autowired
    private StoryCardRepository storyCardRepository;

    @Autowired
    private CircumstanceRepository circumstanceRepository;

    @SuppressWarnings("null")
    public StoryCard save(StoryCard storyCard) {
        return storyCardRepository.save(storyCard);
    }

    public StoryCard getById(long storyCardId) {
        return storyCardRepository.findById(storyCardId)
                .orElseThrow(() -> new RuntimeException("StoryCard not found with id: " + storyCardId));
    }

    public List<StoryCard> getAll() {
        return storyCardRepository.findAll();
    }

    public StoryCard delete(long storyCardId) {
        StoryCard existingStoryCard = getById(storyCardId);
        storyCardRepository.deleteById(storyCardId);
        return existingStoryCard;
    }

    // public void linkCircumstancesWithStoryCard(Long circumstanceId, Long storyCardId) {
    //     Circumstance cc = circumstanceRepository.findById(circumstanceId)
    //             .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    //     StoryCard storyCard = storyCardRepository.findById(storyCardId)
    //             .orElseThrow(() -> new EntityNotFoundException("Course not found"));

    //     cc.getRelatedStoryCards().add(storyCard);
    //     storyCard.getRelatedCircumstances().add(cc);

    // }

}
