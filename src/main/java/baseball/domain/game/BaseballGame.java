package baseball.domain.game;

import java.util.*;

import baseball.domain.Computer;
import baseball.domain.Player;

public class BaseballGame {

	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";

	private static final String INPUT = "숫자를 입력해주세요 : ";
	private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private boolean isPlaying = true;
	private Scanner sc = new Scanner(System.in);

	public void start() {
		Computer computer = new Computer();
		while(isPlaying) {
			System.out.println(INPUT);
			Player player = new Player();
			play(computer, player);
			System.out.println(SUCCESS);
			System.out.println(RESTART);
			restart();
		}
	}

	public void play(Computer computer, Player player) {
		while(player.getStrikeCount() < 3) {
			player.inputBaseBall(sc.next());
			calcBaseball(computer, player);
			System.out.println(scoreBaseball(player));
		}
	}

	public void restart() {
		int input = Integer.parseInt(sc.next());
		if(input == 2) {
			isPlaying = false;
		}
		start();
	}

	public void calcBaseball(Computer computer, Player player) {
		List<Integer> computerBaseball = computer.getBaseball();
		List<Integer> playerBaseball = player.getBaseball();
		for(int i = 0; i < computerBaseball.size(); i++) {
			if(isStrike(computerBaseball.get(i), playerBaseball.get(i))) {
				player.setStrikeCount(1);
				continue;
			}

			if(isBall(computerBaseball, i, playerBaseball.get(i))) {
				player.setBallCount(1);
			}
		}
	}

	public String scoreBaseball(Player player) {
		String resultText = "";
		if(player.getStrikeCount() > 0) {
			resultText += player.getStrikeCount() + " " + STRIKE + " ";
		}

		if(player.getBallCount() > 0) {
			resultText += player.getBallCount() + BALL;
		}

		if(resultText.length() == 0) {
			resultText = NOTHING;
		}

		return resultText;
	}

	private boolean isStrike(int computer, int player) {
		if(computer == player) {
			return true;
		}
		return false;
	}

	private boolean isBall(List<Integer> computer, int index, int player) {
		if(computer.get(index) == player) {
			return false;
		}

		return computer.contains(player);
	}
}
