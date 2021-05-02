package numberBaseBallGame.generator;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class GenerateGameTest {

	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 숫자이외의 문자를 넣았을때.")
	public void 게임_입력값_벨리데이션체크_숫자이외_RED(){
		// given
		GenerateGame newGame = new GenerateGame();

		// when
		assertThatThrownBy(() -> {newGame.playGame("꺄꼬");})
		// than
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("1~9사이의 숫자만 입력해주세요. example : 123, 456 ")
		;
	}
	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 3자리보다 길게 넣았을때.")
	public void 게임_입력값_벨리데이션체크_초과길이_RED(){
		// given
		GenerateGame newGame = new GenerateGame();

		// when
		assertThatThrownBy(() -> {newGame.playGame("1234");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("3글자만 입력해주세요. example : 123, 456 ");
	}

	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 0포험")
	public void 게임_입력값_벨리데이션체크_숫자범위_RED(){
		// given
		GenerateGame newGame = new GenerateGame();

		// when
		assertThatThrownBy(() -> {newGame.playGame("012");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1~9사이의 숫자만 입력해주세요. example : 123, 456 ");
	}

	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 중복숫자 넣았을때.")
	public void 게임_입력값_벨리데이션체크_중복숫자_RED(){
		// given
		GenerateGame newGame = new GenerateGame();

		// when
		assertThatThrownBy(() -> {newGame.playGame("122");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("숫자가 중복되면 안됩니다.");
	}
}