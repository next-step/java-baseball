package app;

import java.io.IOException;

import model.Game;
import service.GameManager;

/**
 * 숫자 야구 게임이 실행되는 클래스입니다.
 */
public class App {
	public static void main(String[] args) throws IOException {
		GameManager gameManager = new GameManager(new Game());
		gameManager.gameStart();
	}
}
