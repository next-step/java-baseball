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

		Score score;
		do {
			score = throwBall(referee, computerNumber, inputValue("숫자를 입력해주세요 : "));
			System.out.println(score);
		} while (!referee.isEnd(score));
	}

	public Score throwBall(Referee referee, List<Integer> computerNumber, String userNumber) {
		Score score = new Score();
		String[] strArr = userNumber.split("");
		for (int i = 0; i < strArr.length; i++) {
			referee.check(score, computerNumber, Integer.parseInt(strArr[i]), i);
		}
		return score;
	}

	public String inputValue(String question) throws IOException {
		System.out.print(question);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		return br.readLine();
	}

	public boolean gameRepeat() throws IOException {
		return inputValue("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n").equals("1");
	}
}
