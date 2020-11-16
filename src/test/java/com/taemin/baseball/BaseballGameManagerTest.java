package com.taemin.baseball;

import org.junit.jupiter.api.Test;

class BaseballGameManagerTest {

	@Test
	void _gameStart() {
		try {
			BaseballGameManager.getInstance().GameStart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
