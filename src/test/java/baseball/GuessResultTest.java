package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class GuessResultTest {

	@Test
	void getMessage() {
		assertThat(new GuessResult(3, 0).getMessage()).isEqualTo("3 스트라이크");
		assertThat(new GuessResult(1, 2).getMessage()).isEqualTo("1 스트라이크 2 볼");
		assertThat(new GuessResult(0, 3).getMessage()).isEqualTo("3 볼");
		assertThat(new GuessResult(0, 2).getMessage()).isEqualTo("2 볼");
		assertThat(new GuessResult(0, 1).getMessage()).isEqualTo("1 볼");
		assertThat(new GuessResult(0, 0).getMessage()).isEqualTo("낫싱");
	}

	@Test
	void isRight() {
		assertThat(new GuessResult(3, 0).isRight()).isEqualTo(true);
		assertThat(new GuessResult(2, 0).isRight()).isEqualTo(false);
	}

	@Test
	void equals() {
		assertThat(new GuessResult(1, 2)).isEqualTo(new GuessResult(1, 2));
	}

}