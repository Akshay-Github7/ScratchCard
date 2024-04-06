package com.ECommerce.ScratchCard.Entity;


import java.math.BigDecimal;
import java.time.LocalDate;

public class ScratchCard {
	
	private String scratchCardGUID;
	private BigDecimal discount;
    private LocalDate expiryDate;
    private boolean isActive;
    private User owner;
	
	
	public ScratchCard(String scratchCardGUID, BigDecimal discount, LocalDate expiryDate, boolean isActive,
			User owner) {
		super();
		this.scratchCardGUID = scratchCardGUID;
		this.discount = discount;
		this.expiryDate = expiryDate;
		this.isActive = isActive;
		this.owner = owner;
	}
	
	
	public String getScratchCardGUID() {
		return scratchCardGUID;
	}
	public void setScratchCardGUID(String scratchCardGUID) {
		this.scratchCardGUID = scratchCardGUID;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
	
	
}
