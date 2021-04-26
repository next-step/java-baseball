package play.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import play.dto.GameResult;
import ui.dto.InputDataDto;


import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGamePlayServiceTest {

	private static BaseBallGamePlayService baseBallGamePlayService;

	@BeforeAll
	static void setUp(){
		baseBallGamePlayService = new BaseBallGamePlayService();
		baseBallGamePlayService.init();
	}


	@DisplayName("정상적인 init 호출로 서로 다른 세 자리의 랜덤 숫자가 셋팅되는지 test")
	@ParameterizedTest
	@ValueSource(ints = {
		1, 2, 3
	})
	void initTest(int time){
		// given
		int size = 3;

		// when
		baseBallGamePlayService.init();

		// then
		assertThat(baseBallGamePlayService.getTargetNumberArray())
			.isNotEmpty()
			.hasSize(size)
			.doesNotHaveDuplicates();
	}


	@DisplayName("정상적인 게임 test")
	@ParameterizedTest
	@ValueSource(ints = {
		123, 456, 543, 234, 631, 876, 463
	})
	void playTest(int number){
		// given
		System.out.println("Target Number: " + baseBallGamePlayService.getTargetNumberArray());
		System.out.println("Input Number: " + number);
		InputDataDto inputDataDto = InputDataDto.getInstance(number);

		// when
		GameResult gameResult = baseBallGamePlayService.play(inputDataDto);

		// then
		assertThat(gameResult).isNotNull();
		System.out.println(gameResult.getResultMessage());
	}
}
