package machine;

import java.util.ArrayList;
import java.util.List;

import display.Display;
import player.Player;
import util.CollectionUtils;

public class Machine {
	private final List<Player> players;
	private final Display display;

	public Machine() {
		this.players = new ArrayList<>();
		this.display = new Display();
	}

	public void run() {
		if (CollectionUtils.isEmpty(this.players)) {
			throw new IllegalArgumentException("플레이어가 없습니다.");
		}

		initialize();
		while (true) {
			display.expose("숫자를 입력해주세요 : ");
			display.input();
		}
	}

	private void initialize() {
		// FIXME 2회차 commit 에 구현하여야 함
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}
}
