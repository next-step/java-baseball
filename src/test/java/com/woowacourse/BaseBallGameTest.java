package com.woowacourse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
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
		
		/* 랜덤숫자의 길이는 DEFAULT_LENGTH 길이이다. */
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
	
	@Test
	public void testGetScoreCount() {
		BaseBallGame baseBallGame = new BaseBallGame();

		Map<String, Integer> scores = new HashMap<String, Integer>();
		Map<Integer, Integer> randomScore = new LinkedHashMap<Integer, Integer>();
		randomScore.put(1, 0);
		randomScore.put(2, 1);
		randomScore.put(3, 2);
		
		/* 3스트라이크 */
		scores = baseBallGame.getScoreCount(randomScore, "123");
		assertEquals(3, (int)scores.get("strike"));
		
		/* 2스트라이크 */
		scores = baseBallGame.getScoreCount(randomScore, "129");
		assertEquals(2, (int)scores.get("strike"));
		
		/* 1스트라이크 */
		scores = baseBallGame.getScoreCount(randomScore, "199");
		assertEquals(1, (int)scores.get("strike"));
		
		/* 3볼 */
		scores = baseBallGame.getScoreCount(randomScore, "312");
		assertEquals(3, (int)scores.get("ball"));
		
		/* 2볼 */
		scores = baseBallGame.getScoreCount(randomScore, "319");
		assertEquals(2, (int)scores.get("ball"));
		
		/* 1볼 */
		scores = baseBallGame.getScoreCount(randomScore, "399");
		assertEquals(1, (int)scores.get("ball"));
		
		/* 1스트라이크 2볼 */
		scores = baseBallGame.getScoreCount(randomScore, "132");
		assertEquals(1, (int)scores.get("strike"));
		assertEquals(2, (int)scores.get("ball"));
		
		/* 낫띵 */
		scores = baseBallGame.getScoreCount(randomScore, "999");
		assertEquals(0, (int)scores.get("strike"));
		assertEquals(0, (int)scores.get("ball"));
	}
}
