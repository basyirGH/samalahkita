import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmyshoes.model.StoryCard;
import com.inmyshoes.repository.StoryCardRepository;

@Service
public class StoryCardService {

    @Autowired
    private StoryCardRepository storyCardRepository;

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

    // public StoryCard update(long storyCardId, StoryCard updatedStoryCard) {
    //     StoryCard existingStoryCard = getById(storyCardId);
    //     existingStoryCard.setName(updatedStoryCard.getName());
    //     return storyCardRepository.save(existingStoryCard);
    // }

    public StoryCard delete(long storyCardId) {
        StoryCard existingStoryCard = getById(storyCardId);
        storyCardRepository.deleteById(storyCardId);
        return existingStoryCard;
    }

}
