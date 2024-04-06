package util;

import java.util.List;

import com.ECommerce.ScratchCard.Entity.Item;
import com.ECommerce.ScratchCard.Entity.User;

public class ValidationUtils {
	
	 public static boolean isValidUser(User user) {
	        return user != null && user.getID() > 0 && user.isActive();
	    }

	    public static boolean isValidItems(List<Item> items) {
	        if (items == null || items.isEmpty()) {
	            return false;
	        }
	        for (Item item : items) {
	            if (item == null || item.getID() <= 0 || !item.isActive()) {
	                return false;
	            }
	        }
	        return true;
	    }

}
