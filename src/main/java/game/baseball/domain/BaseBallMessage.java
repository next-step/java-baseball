package game.baseball.domain;

import java.text.MessageFormat;

public final class BaseBallMessage {

	public static final String NOT_ALLOWED_ZERO = "숫자 0은 허용되지 않습니다.";

	public static final String BASEBALL_LENGTH = MessageFormat.format("길이가 {0}이어야 합니다.",
		BaseBallNumbers.NUMBER_OF_DIGITS);

	public static final String ONLY_ALLOW_NUMBER = "숫자만 허용합니다.";

	public static final String HAS_DUPLICATE = "숫자에 중복이 있습니다.";

	public static final String ALREADY_OVER_GAME = "이미 종료된 게임입니다.";
}
