package com.ECommerce.ScratchCard.Entity;
import java.math.BigDecimal;

public class Item {
	private int ID;
	private String name;
    private BigDecimal rate;
    private boolean isActive;
    
    public Item(int iD, String name, BigDecimal rate, boolean isActive) {
		super();
		ID = iD;
		this.name = name;
		this.rate = rate;
		this.isActive = isActive;
	}
	
}
