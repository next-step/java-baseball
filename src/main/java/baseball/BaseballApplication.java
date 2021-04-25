package baseball;

import java.io.IOException;

import baseball.ui.BaseballUi;

public class BaseballApplication {
	public static void main(String[] args) throws IOException {
		new BaseballUi().playBall();
	}
}
