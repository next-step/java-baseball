package com.woowahan.testprecource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.woowahan.precource.BaseBall;

class BaseBallTest {

	@Test
	void testFindStrikeCount() {
		BaseBall userBall = new BaseBall();
		userBall.situation.add(1);
		userBall.situation.add(2);
		userBall.situation.add(3);
		
		ArrayList<Integer> compareBall = new ArrayList<>();
		compareBall.add(1);
		compareBall.add(3);
		compareBall.add(5);
		
		for(int i = 0; i < 3; i++) {
			if(userBall.situation.get(i) == compareBall.get(i)) {
				userBall.strikeCount++;
			}
		}
		assertTrue(userBall.strikeCount == 1);
	}

	@Test
	void testFindBallCount() {
		BaseBall userBall = new BaseBall();
		userBall.situation.add(1);
		userBall.situation.add(2);
		userBall.situation.add(3);
		
		ArrayList<Integer> compareBall = new ArrayList<>();
		compareBall.add(1);
		compareBall.add(3);
		compareBall.add(5);
		
		for(int i = 0; i < 3; i++) {
			if((userBall.situation.get(i) != compareBall.get(i)) && userBall.situation.contains(compareBall.get(i))) {
				userBall.ballCount++;
			}
		}
		assertTrue(userBall.ballCount == 1);
	}

}
