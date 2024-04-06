package api;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.ScratchCard.Entity.Item;
import com.ECommerce.ScratchCard.Entity.Order;
import com.ECommerce.ScratchCard.Entity.User;

import repository.OrderRepository;
import repository.UserRepository;

@RestController
public class OrderTransactionAPI {

    private final UserRepository userRepository;

    @Autowired
    public OrderTransactionAPI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        // Validate order request
        if (orderRequest == null || orderRequest.getUserId() <= 0 || orderRequest.getItems().isEmpty()) {
            throw new InvalidInputException("Invalid order request.");
        }

        // Fetch user from repository
        User user = userRepository.getUserByID(orderRequest.getUserId());
        if (user == null) {
            throw new InvalidInputException("Invalid user.");
        }

        // Create order and calculate total amount
        Order order = new Order();
        order.setUser(user);
        order.setItems(orderRequest.getItems());
        BigDecimal totalAmount = calculateTotalAmount(order.getItems());
        order.setTotalAmount(totalAmount);

        // Save order to repository
        // orderRepository.placeOrder(order);

        // Return success response
        return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully. Total amount: " + totalAmount);
    }

    private BigDecimal calculateTotalAmount(List<Item> items) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Item item : items) {
            totalAmount = totalAmount.add(item.getRate());
        }
        return totalAmount;
    }
}