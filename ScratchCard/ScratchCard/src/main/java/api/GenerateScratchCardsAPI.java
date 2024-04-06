package api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.ScratchCard.Entity.ScratchCard;

import repository.ScratchCardRepository;

@RestController
public class GenerateScratchCardsAPI {

	private final ScratchCardRepository scratchCardRepository;

    @Autowired
    public GenerateScratchCardsAPI(ScratchCardRepository scratchCardRepository) {
        this.scratchCardRepository = scratchCardRepository;
    }

    @PostMapping("/generateScratchCards")
    public ResponseEntity<String> generateScratchCards(@RequestBody GenerateScratchCardsRequest request) {
        // Validate input parameters
        if (request == null || request.getNumCards() <= 0 || request.getExpiryDays() <= 0) {
            return ResponseEntity.badRequest().body("Invalid input parameters.");
        }

        // Generate scratch cards
        List<ScratchCard> scratchCards = scratchCardRepository.generateScratchCards(request.getNumCards(), request.getExpiryDays());

        // Return success response
        return ResponseEntity.status(HttpStatus.CREATED).body("Generated " + scratchCards.size() + " scratch cards successfully.");
    }
}
