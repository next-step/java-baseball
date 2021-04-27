package baseball;

import java.util.Scanner;

public class Game {
	private static final Scanner scanner = new Scanner(System.in);

	public static String receiveUserInput() {
		return scanner.nextLine();
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		Game game = new Game();
		do {
			game.play();
		} while (game.isFinish());
	}

	public void play() {
		Umpire umpire = new Umpire();
		AttackTeam attackTeam = new AttackTeam();
		attackTeam.prepareAttackNumbers();

		DefenseTeam defenseTeam = new DefenseTeam();
		Score score = new Score(0, 0);
		while (score.getStrikeCount() != 3) {
			defenseTeam.prepareDefenseNumbers();
			score = umpire.judge(attackTeam.getAttackNumbers(), defenseTeam.getDefenseNumbers());
			Game.printMessage(score.getScoreMessage());
		}
	}

	public boolean isFinish() {
		Game.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
		String input = Game.receiveUserInput();

		return input.equals("1");
	}
}
