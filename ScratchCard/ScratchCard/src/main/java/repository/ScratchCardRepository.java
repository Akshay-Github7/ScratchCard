package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ECommerce.ScratchCard.Entity.ScratchCard;
import com.ECommerce.ScratchCard.Entity.User;


@Repository
public interface ScratchCardRepository extends JpaRepository<ScratchCard, String> {
    // You can define custom query methods here if needed
}