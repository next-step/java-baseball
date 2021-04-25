package gamemaster;

import java.util.ArrayList;
import java.util.List;

import baseballnumber.BaseballNumberBoard;
import baseballnumber.BaseballNumberComparer;
import display.Display;
import machine.Machine;
import player.Player;
import util.CollectionUtils;

public class GameMaster {
	protected static final int GAME_CONTINUE = 1;
	protected static final int GAME_STOP = 2;

	private final Machine machine;
	private final Display display;
	private final List<Player> players;

	public GameMaster(Machine machine, Display display) {
		this.machine = machine;
		this.display = display;
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void run() {
		if (CollectionUtils.isEmpty(this.players)) {
			throw new IllegalArgumentException("플레이어가 없습니다");
		}

		if (machine == null) {
			throw new IllegalArgumentException("machine 이 없습니다");
		}

		while (true) {
			List<Player> participants = makeParticipants();
			if (CollectionUtils.isEmpty(participants)) {
				break;
			}

			machine.makeQuestion(display);
			for (Player eachPlayer : players) {
				BaseballNumberBoard numberBoard = process(eachPlayer);
				if (numberBoard.isFinish()) {
					display.exposeRetry();
					int result = eachPlayer.answer(display);
					if (result == GAME_STOP) {
						eachPlayer.exitNumberBaseball();
					}
				}
			}
		}

		display.exposeGameEnd();
	}

	private BaseballNumberBoard process(Player eachPlayer) {
		BaseballNumberComparer comparer = new BaseballNumberComparer(machine.getGoalNumber(),
			eachPlayer.answer(display));
		BaseballNumberBoard numberBoard = comparer.compare();
		display.exposeGameScore(numberBoard); // FIXME : 객체 상태를 보고 적절한 텍스트를 노출한다
		return numberBoard;
	}

	private List<Player> makeParticipants() {
		List<Player> result = new ArrayList<>();
		for (Player eachPlayer : this.players) {
			if (eachPlayer.isParticipant()) {
				result.add(eachPlayer);
			}
		}
		return result;
	}
}
