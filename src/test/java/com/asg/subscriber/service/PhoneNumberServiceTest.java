package com.asg.subscriber.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.asg.subscriber.model.PhoneNumber;
import com.asg.subscriber.model.SubscriberCacheManager;
import com.asg.subscriber.service.impl.PhoneNumberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SubscriberCacheManager.class,
		PhoneNumberServiceImpl.class})
public class PhoneNumberServiceTest {
	
	@Autowired
	private SubscriberCacheManager cache;
	
	@Autowired
	private PhoneNumberService service;

	@Before
	public void setUp() throws Exception {
		cache.addCustomer("Jack", Arrays.asList(new PhoneNumber("0434888999"),new PhoneNumber("04445556667")));
		cache.addCustomer("Miller", Arrays.asList(new PhoneNumber("0434855555"),new PhoneNumber("04445999999")));
	}

	@Test
	public void testGetAllNumbers() {
		
		List<String> numbers = service.getAllPhoneNumbers();
		
		assertEquals(4,numbers.size()) ;
		
	}

}
