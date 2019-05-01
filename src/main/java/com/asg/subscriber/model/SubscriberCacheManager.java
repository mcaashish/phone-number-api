package com.asg.subscriber.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class SubscriberCacheManager {
	
	private Map<String,Set<PhoneNumber>> cache = new HashMap<>();
	
	public void addCustomer(String customer, Set<PhoneNumber> numbers)
	{
		cache.put(customer, numbers);
	}

	public Map<String, Set<PhoneNumber>> getSubscriberCache() {
		return cache;
	}
	
	

}
