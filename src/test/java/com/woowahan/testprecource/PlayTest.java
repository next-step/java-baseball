package com.woowahan.testprecource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.woowahan.precource.Play;

class PlayTest {

	@Test
	void testrandom() {
		ArrayList<Integer> randomBall = new ArrayList<>();
		assertTrue(Play.initBall(randomBall).size() == 3);
		assertTrue(Play.initBall(randomBall).get(0) != Play.initBall(randomBall).get(1));
		assertTrue(Play.initBall(randomBall).get(0) != Play.initBall(randomBall).get(2));
		assertTrue(Play.initBall(randomBall).get(1) != Play.initBall(randomBall).get(2));
		assertTrue(Play.initBall(randomBall).get(0) > 0 && Play.initBall(randomBall).get(0) < 10);
		assertTrue(Play.initBall(randomBall).get(1) > 0 && Play.initBall(randomBall).get(1) < 10);
		assertTrue(Play.initBall(randomBall).get(2) > 0 && Play.initBall(randomBall).get(2) < 10);
	}

	@Test
	void testDuplicateCheck() {
		ArrayList<Integer> a = new ArrayList<>();
		int[] b = new int[] {1,1,5};
		a.add(1);
		a.add(1);
		a.add(5);
		assertTrue(Play.duplicateCheck(a, b));

		b = new int[] {4,5,6};
		a.clear();
		a.add(4);
		a.add(5);
		a.add(6);
		assertFalse(Play.duplicateCheck(a, b));
	}

	@Test
	void testStringToInt() {
		String[] str = new String[3];
		str[0] = "1";
		str[1] = "3";
		str[2] = "5";
		
		assertArrayEquals(Play.stringToInt(str), new int[] {1,3,5});

	}

}
