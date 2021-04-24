package domain.game;

import domain.target.Ball;
import domain.target.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TurnTest {
	private Balls targetBalls;

	@BeforeEach
	public void setUp() {
		List<Ball> targetBallList = new ArrayList<>();
		targetBallList.add(new Ball(1));
		targetBallList.add(new Ball(2));
		targetBallList.add(new Ball(3));
		targetBalls = new Balls(targetBallList);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3:0,3", "2,3,1:3,0", "3,2,1:2,1"}, delimiter = ':')
	@DisplayName("Turn 이 Strike 와 Ball 을 정확히 카운트 하는지 테스트")
	public void testTurn_ReturnPreferCounts(String input, String result) {
		//given
		String[] inputArray = input.split(",");
		List<Ball> inputBallList = new ArrayList<>();
		inputBallList.add(new Ball(Integer.parseInt(inputArray[0])));
		inputBallList.add(new Ball(Integer.parseInt(inputArray[1])));
		inputBallList.add(new Ball(Integer.parseInt(inputArray[2])));
		Balls inputBalls = new Balls(inputBallList);
		//when
		Turn turn = new Turn(inputBalls, targetBalls);
		//then
		String[] resultArray = result.split(",");

		assertAll(
			() -> assertThat(turn).extracting("ballCount").isEqualTo(Integer.parseInt(resultArray[0])),
			() -> assertThat(turn).extracting("strikeCount").isEqualTo(Integer.parseInt(resultArray[1])));
	}
}
