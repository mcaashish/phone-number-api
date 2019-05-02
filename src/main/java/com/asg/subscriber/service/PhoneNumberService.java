package com.asg.subscriber.service;

import java.util.List;

public interface PhoneNumberService {
	
	public List<String> getAllPhoneNumbers();
	
	public List<String> getAllPhoneNumbersByCustomer(String customerName);
	
	public String activateNumber(String number);
}
