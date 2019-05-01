package com.asg.subscriber.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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
@SpringBootTest(classes = { SubscriberCacheManager.class, PhoneNumberServiceImpl.class })
public class PhoneNumberServiceTest {

	@Autowired
	private SubscriberCacheManager cache;

	@Autowired
	private PhoneNumberService service;

	@Before
	public void setUp() throws Exception {
		cache.addCustomer("Jack", new HashSet(Arrays.asList(new PhoneNumber("0434888999"), new PhoneNumber("04445556667"))));
		cache.addCustomer("Miller", new HashSet(Arrays.asList(new PhoneNumber("0434855555"), new PhoneNumber("04445999999"))));
	}

	@Test
	public void testGetAllNumbers() {

		List<String> numbers = service.getAllPhoneNumbers();

		assertEquals(4, numbers.size());

	}

	@Test
	public void testGetAllNumbersByCustomerName() {

		List<String> numbers = service.getAllPhoneNumbersByCustomer("Jack");

		assertEquals(2, numbers.size());

	}

	@Test
	public void testGetAllNumbersByInValidCustomerName() {

		List<String> numbers = service.getAllPhoneNumbersByCustomer("Jack1");

		assertEquals(0, numbers.size());

	}

	@Test
	public void testActivateNumber() {

		PhoneNumber number = cache.getSubscriberCache().values().stream().flatMap(x -> x.stream())
				.filter(n -> n.getPhoneNumber().equals("0434855555")).findAny().get();

		service.activateNumber(number.getPhoneNumber());

		assertEquals(true, number.isActive());

	}

	@Test
	public void testActivateInValidNumber() {

		Optional<PhoneNumber> number = cache.getSubscriberCache().values().stream().flatMap(x -> x.stream())
				.filter(n -> n.getPhoneNumber().equals("0434855555111")).findAny();

		assertEquals(false, number.isPresent());

	}

}
