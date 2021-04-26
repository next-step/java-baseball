package baseballgame.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import basballgame.game.BaseballResult;
import basballgame.game.BaseballSet;
import basballgame.game.Computer;
import basballgame.ui.input.BaseballNumberInput;

public class ComputerTest {

	private Computer computer;

	@BeforeEach
	public void setup() {
		BaseballSet answer = new BaseballSet(1,2,3);
		computer = new Computer(answer);
	}

	/**
	 * 
	 * @param inputString: 	사용자 입력
	 * @param strike: 		사용자 입력에 대한 스트라이크 갯수
	 * @param ball: 		사용자 입력에 대한 볼 갯수
	 */
	@DisplayName("입력값에대한_게임_결과검증_테스트코드")
	@ParameterizedTest
	@CsvSource({
		"456, 0, 0",
		"516, 0, 1",
		"412, 0, 2",
		"231, 0, 3",
		"145, 1, 0",
		"142, 1, 1",
		"135, 1, 1",
		"421, 1, 1",
		"325, 1, 1",
		"243, 1, 1",
		"263, 1, 1",
		"132, 1, 2",
		"321, 1, 2",
		"213, 1, 2",
		"124, 2, 0",
		"123, 3, 0",
	})
	public void Computer_answerCheck_Test(String inputString, int strike, int ball) {
		assertNotNull(inputString);
		BaseballSet userInputBaseballSet = BaseballSet.from(inputString);
		BaseballResult result = computer.checkBaseballNumber(userInputBaseballSet);
		assertTrue(result.getStrike() == strike);
		assertTrue(result.getBall() == ball);
	}
}
