package game.baseball.domain.shared;

public interface Message {
	String REQUIRE_NOT_NULL = "숫자는 반드시 null이 아니어야 합니다.";
	String REQUIRE_THREE_DIGIT = "숫자는 3자리의 수 이어야 합니다.";
	String REQUIRE_DIFFERENT_NUMBER = "각 자리의 숫자들은 서로 다른 수 이어야 합니다.";
	String REQUIRE_ONE_TO_NINE = "각 자리의 숫자들은 1부터 9까지 수 이어야 합니다.";
	String INPUT_WRONG_VALUE = "잘못된 값을 입력하셨습니다.";
	String INPUT_NUMBER = "숫자를 입력해주세요 : ";
	String THREE_STRIKE_GAME_OVER="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	String INPUT_ONE_OR_TWO_FOR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
}
