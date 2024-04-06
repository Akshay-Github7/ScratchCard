package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.ScratchCard.Entity.ScratchCard;
import com.ECommerce.ScratchCard.Entity.User;

import repository.ScratchCardRepository;
@RestController
@RequestMapping("/api/scratch-cards")
public class AllocateScratchCardToUserAPI {

    @Autowired
    private ScratchCard scratchCardService; // Assuming you have a service class to handle scratch card operations

    @PostMapping("/allocate")
    public ResponseEntity<?> allocateScratchCardToUser(@RequestParam Long userId, @RequestParam String scratchCardId) {
        try {
            // Call the service method to allocate the scratch card to the user
            scratchCardService.allocateScratchCardToUser(userId, scratchCardId);
            return ResponseEntity.ok("Scratch card allocated successfully to user.");
        } catch (ScratchCardAllocationException e) {
            return ResponseEntity.badRequest().body("Failed to allocate scratch card: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error.");
        }
    }
}
