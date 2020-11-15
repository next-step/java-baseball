import java.util.Scanner;

import service.BaseballService;

public class BaseballMain {

	private static final String NUMBER_INPUT_QUESTION = "숫자를 입력해주세요 : ";
	private static final String END_OF_GAME_MESSAGE = BaseballService.SCORE_MAX_LENGTH
		+ "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		playBaseball();
	}

	private static void playBaseball() {
		BaseballService baseballService = new BaseballService();
		baseballService.generateGameMasterScore();
		do {
			System.out.print(NUMBER_INPUT_QUESTION);
			baseballService.initScoreMap();
		} while (!baseballService.playUntilEnd(scanner.next()));

		endOfGameProcess();
	}

	private static void endOfGameProcess() {
		System.out.println(END_OF_GAME_MESSAGE);
		int answer = scanner.nextInt();
		if (answer == 1) {
			playBaseball();
		}
		if (answer == 2) {
			System.exit(0);
		}
	}
}
