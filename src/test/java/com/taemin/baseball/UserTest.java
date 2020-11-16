package com.taemin.baseball;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void _getUserNumbers() {
		User user = new User();
		LinkedHashSet<Integer> userNumbers = user.getUserNumbers();
		assertNotNull(userNumbers);
		assertSame(3, userNumbers.size());
		Iterator<Integer> userNumbersIterator =  userNumbers.iterator();
		while(userNumbersIterator.hasNext()) {
			int number = userNumbersIterator.next();
			System.out.print(number);
			assertTrue(number < 10);
			assertTrue(number > 0);
		}
		
	}

}
