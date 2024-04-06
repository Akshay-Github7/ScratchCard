package repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ECommerce.ScratchCard.Entity.ScratchCard;
import com.ECommerce.ScratchCard.Entity.User;

import repository.ScratchCardRepository;



@Repository
public class ScratchCardRepositoryImpl implements ScratchCardRepository {
    
    @Override
    public List<ScratchCard> generateScratchCards(int numCards, int expiryDays) {
        List<ScratchCard> scratchCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            String scratchCardGUID = generateGUID();
            ScratchCard scratchCard = new ScratchCard(scratchCardGUID, expiryDays);
            scratchCards.add(scratchCard);
        }
        return scratchCards;
    }

    @Override
    public void allocateScratchCardToUser(User user, ScratchCard scratchCard) {
        scratchCard.setOwner(user);
        // Implement logic to update scratch card in database
    }

    @Override
    public List<ScratchCard> getScratchCardsByUser(User user) {
        // Implement logic to retrieve scratch cards by user from database
        return null;
    }

    // Utility method to generate unique GUIDs
    private String generateGUID() {
        return UUID.randomUUID().toString();
    }
}