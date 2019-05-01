package com.asg.subscriber.model;

public class PhoneNumber {
	
	private String phoneNumber;
	
	private boolean active;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phoneNumber=" + phoneNumber + ", active=" + active + "]";
	}

	public PhoneNumber(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

}
