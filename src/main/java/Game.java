import java.util.Scanner;

public class Game {
	public void start() {
		do {
			Computer computer = new Computer();
			play(computer);

		} while (quit());
	}

	private void play(Computer computer) {
		Scanner sc = new Scanner(System.in);
		boolean continueGame;
		do {
			System.out.print("숫자를 입력해주세요 : ");
			String userInput = sc.nextLine();
			UserInputConverter userInputConverter = new UserInputConverter(userInput);
			Balls userBalls = new Balls(userInputConverter.convertBallsItem());

			Score score = computer.requestUserBalls(userBalls);
			System.out.println(score.calculateScore());

			continueGame = score.isStrikeout();
		} while(!continueGame);
	}

	private boolean quit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return sc.nextInt() != 2;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
