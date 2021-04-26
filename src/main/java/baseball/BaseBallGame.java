package baseball;

import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
	public static final int RESTART_GAME = 1;
	public static final int END_GAME = 2;
	private static final Scanner SCANNER = new Scanner(System.in);
	private Computer computer;
	private Player player;
	private GameStatus gameStatus;

	public BaseBallGame() {
		this.computer = new Computer();
		this.computer.setNumber(Number.getRandomNumberWithoutDuplicate());
		this.player = new Player();
		this.gameStatus = new GameStatus();
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	private void playerNumberCheck() {
		while (!player.hasNumber()) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = SCANNER.nextLine();
			Number number = validateInput(input);
			player.setNumber(number);
		}
	}

	private Number validateInput(String input) {
		int parseNumber = parseToNumber(input);
		if (parseNumber != -1) {
			return numberValidate(parseNumber);
		}
		return null;
	}

	private int parseToNumber(String input) {
		int returnNumber = -1;
		try {
			returnNumber = Integer.parseInt(input);
		} catch (NumberFormatException numberFormatException) {
			System.out.println("숫자가 아닙니다.");
		}
		return returnNumber;
	}

	private Number numberValidate(int parseNumber) {
		Number number = null;
		try {
			number = Number.isValidate(parseNumber);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
		}
		return number;
	}

	public void getGameResult(Computer computer, Player player) {
		List<String> playerNumberStringList = player.getNumber().numberToStringList();
		for (int playerNumberIndex = 0; playerNumberIndex < playerNumberStringList.size(); playerNumberIndex++) {
			int computerNumberIndex = computer.getNumber()
				.numberToStringList()
				.indexOf(playerNumberStringList.get(playerNumberIndex));
			setBallCount(playerNumberIndex, computerNumberIndex);
		}
	}

	private void setBallCount(int playerNumberIndex, int computerNumberIndex) {
		if (computerNumberIndex != -1) {
			countStrike(playerNumberIndex, computerNumberIndex);
			countBall(playerNumberIndex, computerNumberIndex);
		}
	}

	private void countStrike(int playerNumberIndex, int computerNumberIndex) {
		if (playerNumberIndex == computerNumberIndex) {
			gameStatus.setStrike(gameStatus.getStrike() + 1);
		}
	}

	private void countBall(int playerNumberIndex, int computerNumberIndex) {
		if (playerNumberIndex != computerNumberIndex) {
			gameStatus.setBall(gameStatus.getBall() + 1);
		}
	}

	private void printBallCount() {
		for (BallCountPrinter ballCountPrinter : BallCountPrinter.values()) {
			ballCountPrinter.testAndPrintln(ballCountPrinter, gameStatus);
		}
	}

	private int continueGame() {
		int restartOrEnd = -1;
		while (restartOrEnd != RESTART_GAME && restartOrEnd != END_GAME) {
			System.out.print(
				"게임을 새로 시작하려면 " + BaseBallGame.RESTART_GAME + ", 종료하려면 " + BaseBallGame.END_GAME + "를 입력하세요");
			String input = SCANNER.nextLine();
			restartOrEnd = parseToNumber(input);
		}
		return restartOrEnd;
	}

	private void gameInit() {
		gameStatus.setStrike(0);
		gameStatus.setBall(0);
		player.setNumber(null);
	}

	public int gameStart() {
		while (gameStatus.getStrike() != 3) {
			gameInit();
			playerNumberCheck();
			getGameResult(computer, player);
			printBallCount();
		}
		return continueGame();
	}
}
