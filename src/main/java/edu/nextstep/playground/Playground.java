package edu.nextstep.playground;

import edu.nextstep.game.BaseballGame;
import edu.nextstep.game.BaseballGamer;

public class Playground {
	public void play() {
        playBaseballGame();
	}

	private void playBaseballGame() {
		BaseballGame game = new BaseballGame();
		game.setPlayer(new BaseballGamer("123")); // todo 숫자를 콘솔입력으로 받을 수 있도록 수정
	}
}