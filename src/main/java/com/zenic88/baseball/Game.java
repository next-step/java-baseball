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

		Score score = new Score();
		while (!referee.isEnd(score)) {
			score = new Score();
			System.out.print("숫자를 입력해주세요 : ");

			String userNumber = inputValue();

			throwBall(score, referee, computerNumber, userNumber);
		}
	}

	public void throwBall(Score score, Referee referee, List<Integer> computerNumber, String userNumber) {
		String[] strArr = userNumber.split("");
		for (int i = 0; i < strArr.length; i++) {
			referee.check(score, computerNumber, Integer.parseInt(strArr[i]), i);
		}
		System.out.println(score);
	}

	public String inputValue() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		return br.readLine();
	}

	public boolean gameRepeat() throws IOException {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return inputValue().equals("1");
	}
}
