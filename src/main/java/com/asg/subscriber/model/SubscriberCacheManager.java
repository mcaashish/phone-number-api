package com.asg.subscriber.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SubscriberCacheManager {
	
	private Map<String,List<PhoneNumber>> cache = new HashMap<>();
	
	public void addCustomer(String customer, List<PhoneNumber> numbers)
	{
		cache.put(customer, numbers);
	}

	public Map<String, List<PhoneNumber>> getSubscriberCache() {
		return cache;
	}
	
	

}
