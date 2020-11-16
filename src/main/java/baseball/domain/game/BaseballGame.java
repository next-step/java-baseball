package baseball.domain.game;

import java.util.*;

import baseball.domain.Computer;
import baseball.domain.Player;

public class BaseballGame {

	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";

	private Scanner sc = new Scanner(System.in);

	public void play(Computer computer, Player player) {
		while(player.getStrikeCount() < 3) {
			player.inputBaseBall(sc.next());
			calcBaseball(computer, player);
			System.out.println(scoreBaseball(player));
		}

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
