package baseball.common;

import baseball.domain.BallNumber;

public class PrintMessage {

	public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	public final static String GAME_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public final static String INPUT_NUMBER_MESSAGE = BallNumber.MAX_SIZE + "자리 숫자를 입력하여 주세요 : ";
	public final static String WIN_MESSAGE = BallNumber.MAX_SIZE + "개의 숫자를 모두 맞추셨습니다! 게임 종료";
	public final static String HINT_STRIKE_MESSAGE = "스트라이크";
	public final static String HINT_BALL_MESSAGE = "볼";
	public final static String HINT_NOTHING = "낫싱";

}
