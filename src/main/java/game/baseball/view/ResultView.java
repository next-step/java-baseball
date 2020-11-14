package game.baseball.view;

import game.baseball.domain.BaseBallNumbers;

import java.util.function.Consumer;

public class ResultView {

	public static Consumer<String> printHint() {
		return System.out::println;
	}

	public static Runnable printGameEnded() {
		return () -> System.out.println(BaseBallNumbers.NUMBER_OF_DIGITS + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
