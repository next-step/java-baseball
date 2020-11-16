package com.taemin.baseball;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class BaseballGameManagerTest {

	@Test
	void _gameStart() {
		try {
			BaseballGameManager.getInstance().GameStart();
		} catch (Exception e) {
			fail("Baseball Game start fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
