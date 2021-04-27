package home.work.baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BullsAndCows {
	
	private int gameSize;
	private List<Player> players = new ArrayList<>();
	private Map<Player, Player> opponentMap = new HashMap<>();

	public BullsAndCows(Player p1, Player p2, int gameSize) {
		validateGameSize(gameSize);
		validatePlayer(p1, gameSize);
		validatePlayer(p2, gameSize);
		players.add(p1);
		players.add(p2);
		this.opponentMap.put(p1, p2);
		this.opponentMap.put(p2, p1);
		this.gameSize = gameSize;
	}
	
	public void play() {
		Collections.shuffle(players);
		this.check(players.get(0));
	}
	
	private void validateGameSize(int size) {
		if (size <= 0 || size > 9) throw new RuntimeException("게임하기 위한 숫자의 개수는 1 ~ 9 입니다.");
	}
	
	private void validatePlayer(Player player, int size) {
		if (player == null) throw new IllegalArgumentException("플레이어가 없습니다.");
		int playerNumSize = Optional.of(player).map(Player::getNums).map(List::size).orElse(-1);
		if (playerNumSize != size) throw new IllegalArgumentException("플레이어의 숫자 개수가 게임과 맞지 않습니다.");
	}
	
	private void check(Player player) {
		if (player == null) throw new RuntimeException("상대방이 존재하지 않습니다.");
		List<Integer> receiveNums = CommandLineInterface.receiveNums(player, gameSize);
		Player opponent = this.opponentMap.get(player);
		Answer answer = opponent.question(receiveNums);
		CommandLineInterface.printAnswer(answer);
		if (answer.getStrike() == gameSize) return;
		this.check(this.opponentMap.get(player));
	}
	
}
