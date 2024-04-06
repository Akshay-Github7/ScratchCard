package repositoryImpl;

import repository.OrderRepository;


import java.util.ArrayList;
import java.util.List;

import com.ECommerce.ScratchCard.Entity.Order;

public class OrderRepositoryImpl implements OrderRepository{
	
	private List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public Order getOrderByID(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

}
