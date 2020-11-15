import java.util.Scanner;

import type.GameRoomStatus;

public class GameRoom {
	private static String QUESTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static String GO_ANSWER = "1";
	private static String STOP_ANSWER = "2";
	private static String STOP_MESSAGE = "게임을 종료합니다.";
	
	private Scanner scanner;

	private GameRoomStatus gameRoomStatus = GameRoomStatus.GO;
	
	public void playGame() {
		while (gameRoomStatus.equals(GameRoomStatus.GO)) {
			// TODO : 게임실행

			inputAnswer();
		}

		System.out.println(STOP_MESSAGE);

	}
	
	private void inputAnswer() {
		gameRoomStatus = GameRoomStatus.WAITING_ANSWER;
		
		while (gameRoomStatus.equals(GameRoomStatus.WAITING_ANSWER)) {
			System.out.print(QUESTION_MESSAGE);
		
			scanner = new Scanner(System.in);
			String answer = scanner.nextLine();
			gameRoomStatus = getGameStatus(answer);
		}
	}
	
	private GameRoomStatus getGameStatus(String answer) {
		if (answer.equals(GO_ANSWER)) {
			return GameRoomStatus.GO;
		}
		
		if (answer.equals(STOP_ANSWER)) {
			return GameRoomStatus.STOP;
		}
		
		return GameRoomStatus.WAITING_ANSWER;
	}

}