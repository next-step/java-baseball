package baseball.command;

import static baseball.game.Game.*;

import baseball.Operation;
import baseball.game.GameScore;
import baseball.presenter.DefaultGameScoreMessageGenerator;
import baseball.presenter.GameScoreMessageGenerator;
import baseball.presenter.Presenter;

public class ConsolePresenter implements Presenter {

	public static final String OPERATE =
		"게임을 시작하려면 " + Operation.START.getValue() + ", 종료하려면 " + Operation.EXIT.getValue() + "를 입력하세요.";
	public static final String EXIT = "종료합니다.";
	public static final String START_GAME = "게임 시작";
	public static final String PLAY_BALL = "숫자를 입력해주세요.";
	public static final String INPUT_FAILED = "잘못된 입력값입니다.";
	public static final String GAME_CLEAR = BALL_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

	private final GameScoreMessageGenerator gameScoreMessageGenerator;

	public ConsolePresenter() {
		this.gameScoreMessageGenerator = new DefaultGameScoreMessageGenerator();
	}

	@Override
	public void operate() {
		System.out.println(OPERATE);
	}

	@Override
	public void exit() {
		System.out.println(EXIT);
	}

	@Override
	public void startGame() {
		System.out.println(START_GAME);
	}

	@Override
	public void playBall() {
		System.out.println(PLAY_BALL);
	}

	@Override
	public void inputFailed(String cause) {
		String message = INPUT_FAILED;
		if (cause != null && !cause.isEmpty()) {
			message += "(" + cause + ")";
		}
		System.out.println(message);
	}

	@Override
	public void score(GameScore score) {
		System.out.println(this.gameScoreMessageGenerator.getScoreMessage(score));
	}

	@Override
	public void clear() {
		System.out.println(GAME_CLEAR);
	}
}
