package baseball;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GameMaker {
	private static final int GAME_NUMBER_SIZE = 3;

	public void startNewGame() {
		Set<Integer> gameSet = generateRandomNumber();
		System.out.println(gameSet);
		Set<Integer> playerSet;
		do {
			playerSet = inputNumberUntilSuccess();
			System.out.println(gameSet);
			System.out.println(playerSet);
		} while (!getWinner(gameSet, playerSet));

		try {
			restartGame();
		} catch (RuntimeException e) {
			System.out.println("유효하지 않은 입력입니다. 게임을 종료합니다.");
		}
	}

	public void restartGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int inputNumber = sc.nextInt();
		if(inputNumber == 1) {
			startNewGame();
			return;
		}
		if(inputNumber == 2) {
			System.exit(0);
		}
		throw new RuntimeException();
	}

	public Set<Integer> generateRandomNumber() {
		Random random = new Random();
		Set<Integer> numberSet = new LinkedHashSet<>();
		do {
			numberSet.add(random.nextInt(9) + 1);
		} while (numberSet.size() < GAME_NUMBER_SIZE);
		return numberSet;
	}

	public Set<Integer> inputNumberUntilSuccess() {
		try {
			return inputNumber();
		} catch (RuntimeException e) {
			System.out.printf("중복되지않은 %d자리 정수만 허용됩니다.\n", GAME_NUMBER_SIZE);
			return inputNumberUntilSuccess();
		}
	}

	public Set<Integer> inputNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 :");
		int inputNumber = sc.nextInt();

		validateInputNumber(inputNumber);
		Set<Integer> numberSet = toSetNumber(inputNumber);
		validateInputSetNumber(numberSet);

		return numberSet;
	}

	public Set<Integer> toSetNumber(int number) {
		Set<Integer> numberSet = new LinkedHashSet<>();
		int reverseNumber = 0;
		while (number != 0) {
			reverseNumber = reverseNumber * 10 + number % 10;
			number /= 10;
		}
		while (reverseNumber > 0) {
			numberSet.add(reverseNumber % 10);
			reverseNumber /= 10;
		}
		return numberSet;
	}

	public void validateInputNumber(int number) {
		int pos = (int)(Math.log10(number) + 1);
		if (pos != GAME_NUMBER_SIZE) {
			throw new RuntimeException();
		}
	}

	public void validateInputSetNumber(Set<Integer> numberSet) {
		if (numberSet.size() != GAME_NUMBER_SIZE) {
			throw new RuntimeException();
		}
	}


	public int getStrike(int matchCount) {
		int strikeCount = matchCount;
		if (strikeCount > 0) {
			System.out.printf("%d스트라이크", strikeCount);
		}
		return strikeCount;
	}

	public int getBall(int matchCount, int containCount) {
		int ballCount = containCount - matchCount;
		if (ballCount > 0) {
			System.out.printf("%d볼", ballCount);
		}
		return ballCount;
	}

	public void getScore(int matchCount, int containCount) {
		int strikeCount = getStrike(matchCount);
		int ballCount =  getBall(matchCount, containCount);
		if (strikeCount == 0 && ballCount == 0) {
			System.out.print("낫싱");
		}
	}

	public boolean getWinner(Set<Integer> gameSet, Set<Integer> playerSet) {
		int matchCount = countMatch(gameSet, playerSet);
		int containCount = countContain(gameSet, playerSet);
		if (matchCount == GAME_NUMBER_SIZE) {
			System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임종료\n", GAME_NUMBER_SIZE);
			return true;
		}
		getScore(matchCount, containCount);
		System.out.println();
		return false;
	}

	public int countContain(Set<Integer> gameSet, Set<Integer> playerSet) {
		int containCount = 0;
		Iterator<Integer> playerSetIt = playerSet.iterator();

		while (playerSetIt.hasNext()) {
			int playerNumber = playerSetIt.next();
			containCount += gameSet.contains(playerNumber) ? 1 : 0;
		}
		return containCount;
	}

	public int countMatch(Set<Integer> gameSet, Set<Integer> playerSet) {
		int matchCount = 0;
		Iterator<Integer> gameSetIt = gameSet.iterator();
		Iterator<Integer> playerSetIt = playerSet.iterator();

		while (playerSetIt.hasNext() && gameSetIt.hasNext()) {
			int playerNumber = playerSetIt.next();
			int gameNumber = gameSetIt.next();
			matchCount += (playerNumber == gameNumber) ? 1 : 0;
		}
		return matchCount;
	}
}
