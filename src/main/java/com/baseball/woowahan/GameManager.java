package com.baseball.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.baseball.woowahan.constant.Message;

/**
 * 게임 시작, 관리 모듈
 */
public class GameManager {
	BufferedReader bufferedReader;

	public GameManager() {
		this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) {
		GameManager gameManager = new GameManager();

		try {
			gameManager.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void playGame(Game game) throws IOException {

		while (!game.isCompleted()) {
			System.out.println(Message.INPUT.getMessage());
			game.processInput(bufferedReader.readLine());
		}
	}

	private void start() throws IOException {
		Game game = new Game(new RandomGenerator(), 2);
		while (!game.isFinished()) {
			playGame(game);
			System.out.println(Message.RESTART_OR_END.getMessage());
			game.choiceRestart(bufferedReader.readLine());
		}
	}

}
