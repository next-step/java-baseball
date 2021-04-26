package com.woowacourse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class BaseBallGameTest {
	@Test
	public void testSetRandomNumber() {
		final int DEFAULT_LENGTH = 3;
		BaseBallGame baseBallGame = new BaseBallGame();
		
		Map<Integer, Integer> randomNumber = new LinkedHashMap<Integer, Integer>(); 
		baseBallGame.setRandomNumber(randomNumber);
		
		StringBuilder sb = new StringBuilder();
		for (int key : randomNumber.keySet()) {
            int value = randomNumber.get(key);
 
            sb.append(value);
        }	
		String randomString = sb.toString();
		
		/* 랜덤숫자는 null일 수 없다. */
		assertNotNull(randomString);
		
		/* 랜덤숫자의 길이는D DEFAULT_LENGTH 길이이다. */
		assertEquals(randomString.length(), DEFAULT_LENGTH);
		
		/* 랜덤숫자는 모두 1~9까지 숫자로 이루어져 있다. */
		for (int i = 0; i < randomString.length(); i++) {
			char temp = randomString.charAt(i);
			
			assertTrue(Character.isDigit(temp));
		}

		/* 랜덤숫자의 원소는 중복되지 않는다. */
		int[] numbers = new int[DEFAULT_LENGTH + 1];
		for (int i = 0; i < randomString.length(); i++) {
			int temp = Character.getNumericValue(randomString.charAt(i));
			numbers[temp] = 1;
		}
		
		for (int i = 0; i < randomString.length(); i++) {
			int temp = Character.getNumericValue(randomString.charAt(i));
			assertEquals(1, numbers[temp]);
		}
	}
}
