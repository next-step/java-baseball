package gamemaster;

import java.util.ArrayList;
import java.util.List;

import display.Display;
import machine.Machine;
import player.Player;
import util.CollectionUtils;

public class GameMaster {
	private boolean gameContinue;
	private final Machine machine;
	private final Display display;
	private final List<Player> players;

	public GameMaster(Machine machine, Display display) {
		this.gameContinue = true;
		this.machine = machine;
		this.display = display;
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void run() {
		validateGameMaster();
		List<Player> participants = calculateRemainParticipants();

		while (isGameContinue(participants)) {
			askNumber(participants.isEmpty());
			progressGame(participants);
			participants = calculateRemainParticipants();
		}

		display.exposeGameEnd();
		endGame();
	}

	private void askNumber(boolean remainPlayer) {
		if (this.gameContinue || remainPlayer) {
			machine.question(this.display);
		}
	}

	private void endGame() {
		this.gameContinue = false;
	}

	private boolean isGameContinue(List<Player> participants) {
		return gameContinue && !participants.isEmpty();
	}

	private void progressGame(List<Player> participants) {
		for (Player eachParticipant : participants) {
			eachParticipant.answerNumberAndCalculateBoardScore(this.display, machine.getGoalNumber());
			GameProgress gameProgress = eachParticipant.inputAboutRestartOrStop(this.display);
			decideContinue(eachParticipant, gameProgress);
		}
	}

	private void decideContinue(Player eachParticipant, GameProgress gameProgress) {
		if (gameProgress.isInvalid()) {
			return;
		}

		if (gameProgress.isGameStop()) {
			eachParticipant.exitNumberBaseball();
		}

		machine.generateGoalNumber();
	}

	private void validateGameMaster() {
		if (CollectionUtils.isEmpty(this.players)) {
			throw new IllegalArgumentException("플레이어가 없습니다");
		}

		if (this.machine == null) {
			throw new IllegalArgumentException("machine 이 없습니다");
		}
	}

	private List<Player> calculateRemainParticipants() {
		List<Player> result = new ArrayList<>();
		for (Player eachPlayer : this.players) {
			if (eachPlayer.isParticipant()) {
				result.add(eachPlayer);
			}
		}
		return result;
	}
}
