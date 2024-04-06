package reporting;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ECommerce.ScratchCard.Entity.ScratchCard;
import com.ECommerce.ScratchCard.Entity.User;

import repository.ScratchCardRepository;

public class UserReportGenerator {
    
    private final ScratchCardRepository scratchCardRepository;

    @Autowired
    public UserReportGenerator(ScratchCardRepository scratchCardRepository) {
        this.scratchCardRepository = scratchCardRepository;
    }

    public void generateUserReport(User user) {
        List<ScratchCard> scratchCards = scratchCardRepository.getScratchCardsByUser(user);
        BigDecimal totalWonAmount = calculateTotalWonAmount(scratchCards);
        int unscratchedCardsCount = countUnscratchedCards(scratchCards);

        // Display or return the report
    }

    private BigDecimal calculateTotalWonAmount(List<ScratchCard> scratchCards) {
        BigDecimal totalWonAmount = BigDecimal.ZERO;
        for (ScratchCard scratchCard : scratchCards) {
            if (!scratchCard.isActive()) {
                totalWonAmount = totalWonAmount.add(scratchCard.getDiscount());
            }
        }
        return totalWonAmount;
    }

    private int countUnscratchedCards(List<ScratchCard> scratchCards) {
        int unscratchedCardsCount = 0;
        for (ScratchCard scratchCard : scratchCards) {
            if (scratchCard.isActive()) {
                unscratchedCardsCount++;
            }
        }
        return unscratchedCardsCount;
    }
}