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
		
		/* �������ڴ� null�� �� ����. */
		assertNotNull(randomString);
		
		/* ���������� ���̴�D DEFAULT_LENGTH �����̴�. */
		assertEquals(randomString.length(), DEFAULT_LENGTH);
		
		/* �������ڴ� ��� 1~9���� ���ڷ� �̷���� �ִ�. */
		for (int i = 0; i < randomString.length(); i++) {
			char temp = randomString.charAt(i);
			
			assertTrue(Character.isDigit(temp));
		}

		/* ���������� ���Ҵ� �ߺ����� �ʴ´�. */
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
