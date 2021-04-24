package baseball.controller;

import baseball.service.Baseball;

public class BaseballController {

	public static void main(String[] args) {

		Baseball baseball =  new Baseball();
		baseball.startGame();
	}

}