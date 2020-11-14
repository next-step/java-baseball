package baseball;

import static baseball.util.CompareComputerPlayerNumber.*;
import static baseball.util.GenerateComputerNumber.*;
import static baseball.util.GetPlayerNumber.*;

import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
	public static void main(String[] args) {
		start();
	}

	private static void start() {
		boolean isPlaying = true;
		while (isPlaying) {
			Set<Integer> computerNumber = generateComputerNumber();
			playingBaseball(computerNumber);
			isPlaying = askReplayingGame();
		}
	}

	private static boolean askReplayingGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String command = getInputPlayerNumber();
		if (command.equals("1")) {
			return true;
		}
		return false;
	}

	private static void playingBaseball(Set<Integer> computerNumber) {
		Boolean eachGamePlaying = true;

		while (eachGamePlaying) {
			System.out.print("숫자를 입력해주세요 : ");
			Set<Integer> playerNumber = getPlayerNumber(getInputPlayerNumber());
			eachGamePlaying = checkPlayerNumber(computerNumber, playerNumber);
		}

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private static String getInputPlayerNumber() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}

	private static Boolean checkPlayerNumber(Set<Integer> computerNumber, Set<Integer> playerNumber) {
		if (playerNumber == null) {
			System.out.println("1~9 사이의 서로 다른 3자리 숫자를 입력해주세요.");
			return true;
		}

		Integer[] score = compareStrikeAndBall(computerNumber, playerNumber);
		printResult(score);

		return (score[0] == 3) ? false : true;
	}

	private static void printResult(Integer[] score) {
		if (score[0] == 0 && score[1] == 0) {
			System.out.println("낫싱");
			return;
		}
		makeResultState(score);
	}

	private static void makeResultState(Integer[] score) {

		if (score[0] > 0) {
			System.out.print(score[0] + " 스트라이크 ");
		}
		if (score[1] > 0) {
			System.out.print(score[1] + " 볼 ");
		}
		System.out.println("");
	}
}
