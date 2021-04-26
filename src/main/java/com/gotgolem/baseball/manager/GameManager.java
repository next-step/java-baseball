package com.gotgolem.baseball.manager;

import com.gotgolem.baseball.asset.game.GameState;
import com.gotgolem.baseball.asset.number.RandomNumberGenerator;
import com.gotgolem.baseball.asset.pitch.PitchHint;
import com.gotgolem.baseball.asset.pitch.ThreePitches;
import com.gotgolem.baseball.asset.player.Player;
import com.gotgolem.baseball.exception.PlayerInputException;
import com.gotgolem.baseball.service.BaseballService;
import com.gotgolem.baseball.service.ConsoleUiService;
import com.gotgolem.baseball.service.PlayerService;

public class GameManager {

	private final BaseballService baseballService;
	private final PlayerService playerService;
	private final ConsoleUiService consoleUiService;
	private GameState gameState;
	private final Player computer;

	public GameManager() {
		baseballService = new BaseballService(new RandomNumberGenerator());
		playerService = new PlayerService(baseballService);
		consoleUiService = new ConsoleUiService();
		gameState = GameState.WAITING;
		computer = new Player();
	}

	public void play() {
		while (gameState != GameState.END) {
			init();
			progressGame();
			requestGameState();
		}
	}

	private void init() {
		gameState = GameState.PLAYING;
		playerService.changePlayerPitches(computer);
	}

	private void progressGame() {
		while (gameState == GameState.PLAYING) {
			final ThreePitches pitches = requestPitches();
			final PitchHint hint = getPitchHint(computer.getPitches(), pitches);
			printPitchHint(hint);
			printEndingIfWin(hint);
			changeGameStateToEndIfWin(hint);
		}
	}

	private void requestGameState() {
		boolean requestSuccess = false;
		while (!requestSuccess) {
			requestSuccess = changeGameStateByPlayer();
		}
	}

	private boolean changeGameStateByPlayer() {
		final String gameStateString = consoleUiService.requestContinue();
		try {
			gameState = playerService.parseGameStateString(gameStateString);
			return true;
		} catch (PlayerInputException e) {
			consoleUiService.printGuideMessage(e.getMessage());
		}
		return false;
	}

	private ThreePitches requestPitches() {
		final String pitchesString = consoleUiService.requestPitches();
		try {
			return playerService.parsePitchesString(pitchesString);
		} catch (PlayerInputException e) {
			consoleUiService.printGuideMessage(e.getMessage());
			return null;
		}
	}

	private PitchHint getPitchHint(ThreePitches target, ThreePitches comparison) {
		if (target == null || comparison == null) {
			return null;
		}
		return baseballService.getPitchHint(target, comparison);
	}

	private void printPitchHint(PitchHint pitchHint) {
		if (pitchHint == null) {
			return;
		}
		final int strikeCount = pitchHint.getStrikeCount();
		final int ballCount = pitchHint.getBallCount();
		consoleUiService.printPitchHint(strikeCount, ballCount);
	}

	private void printEndingIfWin(PitchHint pitchHint) {
		if (pitchHint != null && pitchHint.getStrikeCount() == 3) {
			consoleUiService.printEnding();
		}
	}

	private void changeGameStateToEndIfWin(PitchHint pitchHint) {
		if (pitchHint != null && pitchHint.getStrikeCount() == 3) {
			gameState = GameState.END;
		}
	}

}
