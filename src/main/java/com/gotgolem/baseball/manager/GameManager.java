package com.gotgolem.baseball.manager;

import com.gotgolem.baseball.asset.game.GameState;
import com.gotgolem.baseball.asset.number.RandomNumberGenerator;
import com.gotgolem.baseball.asset.player.Player;
import com.gotgolem.baseball.service.BaseballService;
import com.gotgolem.baseball.service.PlayerService;

public class GameManager {

	private final BaseballService baseballService;
	private final PlayerService playerService;
	private GameState gameState;
	private final Player computer;

	public GameManager() {
		baseballService = new BaseballService(new RandomNumberGenerator());
		playerService = new PlayerService(baseballService);
		gameState = GameState.WAITING;
		computer = new Player();
	}

	public void play() {
		while (gameState != GameState.END) {
			init();
			progressGame();
			gameState = getGameState();
		}
	}

	public void init() {
		gameState = GameState.PLAYING;
		playerService.changePlayerPitches(computer);
	}

	public void progressGame() {
		while (gameState == GameState.PLAYING) {
			// TODO 게임이 종료될 수 있도록 임시 break
			break;
		}
	}

	public GameState getGameState() {
		// TODO 게임이 종료될 수 있도록 임시 값 설정
		return GameState.END;
	}

}
