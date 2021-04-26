package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.Ball;
import NumberBaseBallGame.domain.BallNumberMatchResult;
import NumberBaseBallGame.generater.BallNumberMatcher;
import NumberBaseBallGame.generater.GenerateGame;
import org.junit.jupiter.api.*;

import java.util.List;

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

	@Nested
	@DisplayName("PlayNewGame!")
	class PlayNewGame{
		GenerateGame aGame = new GenerateGame();
		List<Ball> gameNumbers = aGame.getGameNumbers();;

		@DisplayName("3. 게임 [😊] 정확값을 입력해서 게임에서 승리했을때.")
		public void game_clear_green(){
			// given
			String allMatchNumber = "";

			for(Ball item : gameNumbers){
				allMatchNumber+=String.valueOf(item);
			}

			// when
			BallNumberMatchResult results = aGame.playGame(allMatchNumber);
			// than
			assertThat(results)
					.extracting("finish")
					.isEqualTo(true);
			assertThat(results)
					.extracting("hint")
					.isEqualTo("스트라이크 3볼 ")
			;
		}

		@RepeatedTest(1000)
		@DisplayName("4. 스트라이크 [😊], 5. 볼 [😊],6. 포볼 / 낫싱 [😊], 3. 게임 [😊] 게임 승리")
		public void game_strike_green(){
			// given
			String randomNumbers = "";
			// when
			BallNumberMatchResult results = aGame.playGame(randomNumbers);
			// than
			if(results.isAllMatch()){
				assertThat(results)
						.extracting("hint")
						.isEqualTo("스트라이크 3볼 ");
			}
			if(!results.isAllMatch()){
//				assertThat(results.getHint())
//						.isIn(
//								"스트라이크 1볼 ",
//								"스트라이크 2볼 ",
//								"1볼 ",
//								"2볼 ",
//								"3볼 ",
//								"스트라이크 1볼 1볼 ",
//								"스트라이크 2볼 1볼 ",
//								"스트라이크 1볼 2볼 ",
//								"낫싱 "
//						);
			}
		}
	}
}