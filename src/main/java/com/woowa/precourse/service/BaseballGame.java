package com.woowa.precourse.service;

import java.util.Scanner;

import com.woowa.precourse.util.Answer;
import com.woowa.precourse.util.AnswerGenerator;
import com.woowa.precourse.util.QueryConverter;

public class BaseballGame implements Game {
	private AnswerGenerator uniqueNumberMaker;
	private QueryConverter validNumberConverter;
	private Scanner scanner;

	/* 생성자 */
	public BaseballGame() {
		uniqueNumberMaker = new AnswerGenerator();
		validNumberConverter = new QueryConverter();
		scanner = new Scanner(System.in);
	}

	/* 게임 실행 */
	@Override
	public boolean run() {
		Answer answer = uniqueNumberMaker.create();

		int[] inputNumber = {};
		int[] gameResult = {};

		do {
			inputNumber = setInputNumber();
			gameResult = answer.compareTo(inputNumber);
		} while (!checkGameResult(gameResult));

		return isContinue();
	}

	/* 게임 종료 */
	@Override
	public void exit() {
		scanner.close();
	}

	/* 숫자 입력 */
	private int[] setInputNumber() {
		int[] inputNumber;

		do {
			try {
				System.out.print("숫자를 입력해주세요 : ");
				inputNumber = validNumberConverter.convert(scanner.nextLine());

				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} while (true);

		return inputNumber;
	}

	/* 입력에 대한 결과 체크 */
	private boolean checkGameResult(int[] gameResult) {
		if (isThreeStrike(gameResult)) {
			return true;
		}

		isNothing(gameResult);
		isStrikeAndBall(gameResult);

		System.out.println();

		return false;
	}

	/* 정답인 경우 */
	private boolean isThreeStrike(int[] gameResult) {
		boolean result = false;

		if (gameResult[0] == 3) {
			System.out.println(gameResult[0] + " " + "스트라이크 ");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			result = true;
		}

		return result;
	}

	/* 정답이 아닌 경우(STRIKE AND BALL) */
	private void isStrikeAndBall(int[] gameResult) {
		if (gameResult[0] != 0) {
			System.out.print(gameResult[0] + " " + "스트라이크 ");
		}

		if (gameResult[1] != 0) {
			System.out.print(gameResult[1] + "볼");
		}
	}

	/* 정답이 아닌 경우(NOTHING) */
	private void isNothing(int[] gameResult) {
		if ((gameResult[0] == 0) && (gameResult[1] == 0)) {
			System.out.print("낫싱");
		}
	}

	/* 종료 여부 묻기 */
	private boolean isContinue() {
		String command = "";

		do {
			System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
			command = scanner.nextLine();
		} while (isRightType(command));

		return isAnswer(command);
	}

	/* 종료 여부 결과 받기 */
	private boolean isAnswer(String command) {
		boolean result = false;

		if ((command.equals("1"))) {
			result = true;
		}

		if ((command.equals("2"))) {
			result = false;
		}

		return result;
	}

	/* 게임 종료 시, 1 또는 2 체크 */
	private boolean isRightType(String command) {
		if ((!command.equals("1")) && (!command.equals("2"))) {
			System.out.println("입력 값이 잘못되었습니다.");

			return true;
		}

		return false;
	}
}
