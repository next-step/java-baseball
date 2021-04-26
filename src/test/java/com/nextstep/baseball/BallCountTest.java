package com.nextstep.baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class BallCountTest {

	@Test
	void testStrikeCheck() {
		String[] arrAutoNum = {"1","2","3"};
		String[] arrBallNum = {"1","2","3"};
		
		int resultCnt = BallCount.strikeCheck(arrAutoNum, arrBallNum);
		String resultString = String.valueOf(resultCnt);
		String arrCnt[] = {"0","1","2","3"};
		List<String> arrCntList = Arrays.asList(arrCnt);

		assertTrue(arrCntList.contains(resultString));
	}

	@Test
	void testBallCheck() {
		String[] arrAutoNum = {"1","2","3"};
		String[] arrBallNum = {"4","5","9"};
		
		int resultCnt = BallCount.ballCheck(arrAutoNum, arrBallNum);
		String resultString = String.valueOf(resultCnt);
		String arrCnt[] = {"0","1","2","3"};
		List<String> arrCntList = Arrays.asList(arrCnt);

		assertTrue(arrCntList.contains(resultString));
	}

	@Test
	void testBallCheck2() {
		String autoNum = "1";
		String[] arrBallNum = {"1","2","3"};
		
		int resultCnt = BallCount.ballCheck2(autoNum, 0, arrBallNum);
		String resultString = String.valueOf(resultCnt);
		String arrCnt[] = {"0","1"};
		List<String> arrCntList = Arrays.asList(arrCnt);

		assertTrue(arrCntList.contains(resultString));
	}

}
