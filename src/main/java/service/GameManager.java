package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import model.Game;

/**
 * 숫자 야구 게임 흐름을 관리합니다.
 */
public class GameManager {

	private final Game game;

	public GameManager(Game game) {
		this.game = game;
	}

	/**
	 * 흐름대로 게임을 실행합니다.
	 * @throws IOException
	 */
	public void gameStart() throws IOException {
		while (this.game.checkStrikeAndBall()) {
			this.printPleaseInputNumber();
			this.game.setUser(inputUserNumber());
			this.game.computeStrikeAndBall();
			this.printStrikeAndBall();
		}
	}

	/**
	 * 유저의 입력을 받아, 저장합니다.
	 * @return 유저의 입력
	 * @throws IOException
	 */
	private int[] inputUserNumber() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inputs = Arrays
			.stream(br.readLine().split(""))
			.mapToInt(Integer::parseInt)
			.toArray();
		return inputs;
	}

	/**
	 *	숫자를 입력해 달라는 문자열을 콘솔에 출력합니다.
 	 */
	private void printPleaseInputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	/**
	 * 스트라이크와, 볼의 개수를 콘솔에 출력합니다.
	 */
	private void printStrikeAndBall() {
		if (game.getStrike() > 0 && game.getBall() > 0) {
			System.out.println(game.getStrike() + " 스트라이크 " + game.getBall() + "볼");
			return;
		}
		if (game.getStrike() == 0 && game.getBall() == 0) {
			System.out.println("낫싱");
			return;
		}
		if (game.getStrike() == 0) {
			System.out.println(game.getBall() + "볼");
			return;
		}
		if (game.getBall() == 0) {
			System.out.println(game.getStrike() + " 스트라이크");
			return;
		}
	}
}
