package me.right42.domain.type;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

class GameStatusTest {

	@Test
	void findStartCodeTest(){
		String code = "1";

		GameStatus byCode = GameStatus.findByCode(code);

		assertThat(byCode).isEqualTo(GameStatus.START);
		assertThat(byCode.getCode()).isEqualTo(code);
	}

	@Test
	void findEndCodeTest(){
		String code = "2";

		GameStatus byCode = GameStatus.findByCode(code);

		assertThat(byCode).isEqualTo(GameStatus.END);
		assertThat(byCode.getCode()).isEqualTo(code);
	}

	@Test
	void notFindCodeTest(){
		String code = "3";
		String errorMessage = String.format("해당 코드는 없습니다. [%s]", code);

		assertThatThrownBy(() -> GameStatus.findByCode(code))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(errorMessage);

	}
}