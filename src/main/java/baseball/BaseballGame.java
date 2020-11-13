package baseball;

import static baseball.GenerateComputerNumber.*;
import static baseball.GetPlayerNumber.*;

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
			isPlaying = false;
		}
	}

	private static void playingBaseball(Set<Integer> computerNumber) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = sc.next();
			Set<Integer> playerNumber = getPlayerNumber(input);
			checkPlayerNumber(computerNumber, playerNumber);
		}

	}

	private static void checkPlayerNumber(Set<Integer> computerNumber, Set<Integer> playerNumber) {
		if (playerNumber == null) {
			System.out.println("1~9 사이의 서로 다른 3자리 숫자를 입력해주세요.");
			return;
		}
	}
}
