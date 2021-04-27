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
		
		/* �������ڴ� null�� �� ����. */
		assertNotNull(randomString);
		
		/* ���������� ���̴� DEFAULT_LENGTH �����̴�. */
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
	
	@Test
	public void testGetScoreCount() {
		BaseBallGame baseBallGame = new BaseBallGame();

		Map<String, Integer> scores = new HashMap<String, Integer>();
		Map<Integer, Integer> randomScore = new LinkedHashMap<Integer, Integer>();
		randomScore.put(1, 0);
		randomScore.put(2, 1);
		randomScore.put(3, 2);
		
		/* 3��Ʈ����ũ */
		scores = baseBallGame.getScoreCount(randomScore, "123");
		assertEquals(3, (int)scores.get("strike"));
		
		/* 2��Ʈ����ũ */
		scores = baseBallGame.getScoreCount(randomScore, "129");
		assertEquals(2, (int)scores.get("strike"));
		
		/* 1��Ʈ����ũ */
		scores = baseBallGame.getScoreCount(randomScore, "199");
		assertEquals(1, (int)scores.get("strike"));
		
		/* 3�� */
		scores = baseBallGame.getScoreCount(randomScore, "312");
		assertEquals(3, (int)scores.get("ball"));
		
		/* 2�� */
		scores = baseBallGame.getScoreCount(randomScore, "319");
		assertEquals(2, (int)scores.get("ball"));
		
		/* 1�� */
		scores = baseBallGame.getScoreCount(randomScore, "399");
		assertEquals(1, (int)scores.get("ball"));
		
		/* 1��Ʈ����ũ 2�� */
		scores = baseBallGame.getScoreCount(randomScore, "132");
		assertEquals(1, (int)scores.get("strike"));
		assertEquals(2, (int)scores.get("ball"));
		
		/* ���� */
		scores = baseBallGame.getScoreCount(randomScore, "999");
		assertEquals(0, (int)scores.get("strike"));
		assertEquals(0, (int)scores.get("ball"));
	}
}
