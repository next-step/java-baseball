package com.zenic88.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Game {

	public void start() throws IOException {
		Computer computer = new Computer();
		Referee referee = new Referee();

		List<Integer> computerNumber = computer.generate();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Score score = new Score();

		while (!referee.isEnd(score)) {
			score = new Score();
			System.out.print("숫자를 입력해주세요 : ");

			String userNumber = br.readLine();

			throwBall(score, referee, computerNumber, userNumber);

			System.out.println(score);
		}

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void throwBall(Score score, Referee referee, List<Integer> computerNumber, String userNumber) {
		String[] strArr = userNumber.split("");
		for (int i = 0; i < strArr.length; i++) {
			referee.check(score, computerNumber, Integer.parseInt(strArr[i]), i);
		}
	}
}
