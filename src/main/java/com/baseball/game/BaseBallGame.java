package com.baseball.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.baseball.message.UIMessage;
import com.baseball.rule.BallGenerator;

public class BaseBallGame {

	private void startGame() {
		//
		boolean onGame = true;

		while (onGame) {
			startInning();

			//게임 재개 여부 확인
			System.out.println(UIMessage.RESUME_INFO);

			Scanner scanner = new Scanner(System.in);
			String resumeText = scanner.nextLine();

			if ("1".equals(resumeText)) {
				onGame = true;
			} else if ("2".equals(resumeText)) {
				onGame = false;
			}
		}
	}

	private void startInning() {
		//TODO 3자리 숫자 생성
		String testInput = "123";// 삭제 예정
		// BallGenerator ballGenerator = new BallGenerator();
		// ArrayList<Integer> generatedNumbers = (ArrayList<Integer>)ballGenerator.generateNumber();

		boolean strikeout = false;
		while (!strikeout) {
			// infoMessage
			System.out.print(UIMessage.TRY_INFO);

			Scanner scanner = new Scanner(System.in);
			String numbers = scanner.nextLine();

			//TODO 입력값 유효성 검증

			//TODO strike,ball 판단

			//FIX 정답 여부 확인
			if (testInput.equals(numbers)) {
				strikeout = true;
			}
		}
	}

	public static void main(String[] args) {
		//
		BaseBallGame game = new BaseBallGame();
		game.startGame();

	}
}
