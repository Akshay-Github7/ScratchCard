package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ECommerce.ScratchCard.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can define custom query methods here if needed
}
