package baseball;

import java.util.function.Function;
import java.util.function.Predicate;

public enum BallCountPrinter {
	NOTHING((gameStatus) -> gameStatus.getStrike() + gameStatus.getBall() == 0, (gameStatus) -> "낫싱"),
	STRIKE_AND_BALL((gameStatus) -> gameStatus.getStrike() > 0 && gameStatus.getBall() > 0,
		(gameStatus) -> gameStatus.getStrike() + "스트라이크" + gameStatus.getBall() + "볼"),
	STRIKE((gameStatus) -> gameStatus.getStrike() != 3 && gameStatus.getStrike() > 0 && gameStatus.getBall() == 0,
		(gameStatus) -> gameStatus.getStrike() + "스트라이크"),
	BALL((gameStatus) -> gameStatus.getStrike() == 0 && gameStatus.getBall() > 0,
		(gameStatus) -> gameStatus.getBall() + "볼"),
	THREE_STRIKE((gameStatus) -> gameStatus.getStrike() == 3, (gameStatus) -> Number.DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임종료");

	Predicate<GameStatus> predicate;
	Function<GameStatus, String> function;

	BallCountPrinter(Predicate<GameStatus> predicate,
		Function<GameStatus, String> function) {
		this.predicate = predicate;
		this.function = function;
	}

	public void testAndPrintln(BallCountPrinter ballCountPrinter, GameStatus gameStatus) {
		if (ballCountPrinter.predicate.test(gameStatus)) {
			System.out.println(function.apply(gameStatus));
		}
	}
}
