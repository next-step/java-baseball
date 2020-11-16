import java.util.Scanner;

import type.GameRoomStatus;

public class GameRoom {
	private static String ANSWER_OPEN = "1";
	private static String ANSWER_CLOSED = "2";
	private static String QUESTION = "게임을 새로 시작하려면 " + ANSWER_OPEN + ", 종료하려면 " + ANSWER_CLOSED + "를 입력하세요.";
	
	private static String GOODBYE_MESSAGE = "게임을 종료합니다.";
	
	private Scanner scanner;

	private GameRoomStatus gameRoomStatus = GameRoomStatus.OPEN;
	
	public void visit() {
		while (gameRoomStatus.equals(GameRoomStatus.OPEN)) {
			Game game = new Game();
			game.play();

			askIfExit();
		}

		sayGoodBye();
	}
	
	private void askIfExit() {
		gameRoomStatus = GameRoomStatus.WAITING_ANSWER;
		
		while (gameRoomStatus.equals(GameRoomStatus.WAITING_ANSWER)) {
			setQuestion();
		
			String answer = getAnswer();
			
			setGameRoomStatus(answer);
		}
	}
	
	private void setQuestion() {
		System.out.print(QUESTION);
	}
	
	private String getAnswer() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	private void setGameRoomStatus(String answer) {
		if (answer.equals(ANSWER_OPEN)) {
			gameRoomStatus = GameRoomStatus.OPEN;
		}
		
		if (answer.equals(ANSWER_CLOSED)) {
			gameRoomStatus = GameRoomStatus.CLOSED;
		}
		
		gameRoomStatus = GameRoomStatus.WAITING_ANSWER;
	}
	
	private void sayGoodBye() {
		System.out.println(GOODBYE_MESSAGE);
	}

}