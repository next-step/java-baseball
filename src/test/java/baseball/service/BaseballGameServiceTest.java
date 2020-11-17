package baseball.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.BaseballGoalNumber;

class BaseballGameServiceTest {

	private static List<Integer> baseballGoalList = null;

	@BeforeEach
	void setUp() {
		// 랜덤 상수 생성
		// baseballGoalList = new BaseballGoalNumber().baseballGoalNumber;

		Integer[] array = {5, 4, 7};
		baseballGoalList = new ArrayList<>(Arrays.asList(array));

		System.out.println("Baseball Game Result = " + baseballGoalList); // [5, 4 ,7]
	}

	@DisplayName("가상 데이터를 만들어서 랜덤 야구게임 수와 유저 입력 수 비교 테스트 가능")
	@ParameterizedTest
	@CsvSource(value = {"1:5:4:true", "5:1:8:true", "5:4:9:true", "6:3:4:true", "5:7:4:true", "5:4:7:false"},
		delimiter = ':')
	void isThreeStrikeGameTest(int first, int second, int third, boolean result) {

		Integer[] array = {first, second, third};
		List<Integer> userInputList = new ArrayList<>(Arrays.asList(array));

		assertThat(BaseballGameService.isThreeStrikeGame(baseballGoalList, userInputList)).isEqualTo(result);
	}

	@DisplayName("랜덤 난수를 생성해, 3Strike가 될때 까지 테스트 및 확인")
	@Test
	void limitTest() {

		int count = 0;
		while (BaseballGameService.isThreeStrikeGame(baseballGoalList, new BaseballGoalNumber().baseballGoalNumber)) {

			count++;
		}

		System.out.println("Count : " + count);
		assertThat(BaseballGameService.strike).isEqualTo(BaseballGameService.BASEBALL_GAME_COUNT);
	}
}

