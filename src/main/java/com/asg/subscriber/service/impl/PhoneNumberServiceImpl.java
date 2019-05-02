package com.asg.subscriber.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asg.subscriber.model.PhoneNumber;
import com.asg.subscriber.model.SubscriberCacheManager;
import com.asg.subscriber.service.PhoneNumberService;

@RestController
public class PhoneNumberServiceImpl implements PhoneNumberService{
	
	@Autowired
	private SubscriberCacheManager cache;

	@Override
	@RequestMapping(value ="/rest/all",method=RequestMethod.GET)
	public List<String> getAllPhoneNumbers() {
		System.out.println("calling all...");
		List<String> allPhoneList = cache.getSubscriberCache().values().stream().flatMap(x-> x.stream()).map(x->x.getPhoneNumber()).collect(Collectors.toList());
		return allPhoneList;
	}

	@Override
	@RequestMapping(value ="/rest/all/{customer}",method=RequestMethod.GET)
	public List<String> getAllPhoneNumbersByCustomer(@PathVariable String customer) {
		Set<PhoneNumber> list = cache.getSubscriberCache().get(customer);
		if(list==null)
		{
			System.err.println("Customer " + customer + " not available in records");
			return Collections.EMPTY_LIST;
		}
		List<String> phoneList = list.stream().map(x->x.getPhoneNumber()).collect(Collectors.toList());
		return phoneList;
	}

	@Override
	@RequestMapping(value ="/rest/activate/{number}",method=RequestMethod.POST)
	public String activateNumber(@PathVariable String number) {
		String message="";
		Optional<PhoneNumber> phoneNumberOptional = cache.getSubscriberCache().values().stream().flatMap(x->x.stream()).filter( n -> n.getPhoneNumber().equals(number)).findAny();
		if(phoneNumberOptional.isPresent()) {
			phoneNumberOptional.get().setActive(true);
			message = number + " is activated";
		}else
		{
			message = "Phone number " + number + " not available in records";
		}
		
		return message;
		
	}
	
	

}
