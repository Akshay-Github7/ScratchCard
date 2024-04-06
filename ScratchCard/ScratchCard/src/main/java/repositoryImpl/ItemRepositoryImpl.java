package repositoryImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ECommerce.ScratchCard.Entity.Item;

import repository.ItemRepository;

public class ItemRepositoryImpl implements ItemRepository {
	private Connection connection;

    // Constructor to inject database connection
    public ItemRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM Items WHERE IsActive = true";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Item item = mapResultSetToItem(resultSet);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    // Utility method to map ResultSet to Item object
    private Item mapResultSetToItem(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setID(resultSet.getInt("ID"));
        item.setName(resultSet.getString("Name"));
        item.setRate(resultSet.getBigDecimal("Rate"));
        item.setActive(resultSet.getBoolean("IsActive"));
        return item;
    }
}
