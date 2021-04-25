package NumberBaseBallGame;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class PlayGameTest {

	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 숫자이외의 문자를 넣았을때.")
	public void 게임_입력값_벨리데이션체크_숫자이외_RED(){
		// given
		PlayGame playGame = new PlayGame();;

		// when
		assertThatThrownBy(() -> {playGame.playGame("꺄꼬");})
		// than
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("1~9사이의 숫자만 입력해주세요. example : 123, 456 ")
		;
	}
	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 3자리보다 길게 넣았을때.")
	public void 게임_입력값_벨리데이션체크_초과길이_RED(){
		// given
		PlayGame playGame = new PlayGame();;

		// when
		assertThatThrownBy(() -> {playGame.playGame("1234");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("3글자만 입력해주세요. example : 123, 456 ");
	}

	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 0포험")
	public void 게임_입력값_벨리데이션체크_숫자범위_RED(){
		// given
		PlayGame playGame = new PlayGame();;

		// when
		assertThatThrownBy(() -> {playGame.playGame("012");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1~9사이의 숫자만 입력해주세요. example : 123, 456 ");
	}

	@Test
	@DisplayName("3. 게임 [X] 게임 입력값 벨리데이션체크 중복숫자 넣았을때.")
	public void 게임_입력값_벨리데이션체크_중복숫자_RED(){
		// given
		PlayGame playGame = new PlayGame();

		// when
		assertThatThrownBy(() -> {playGame.playGame("122");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("숫자가 중복되면 안됩니다.");
	}

	@Nested
	@DisplayName("PlayNewGame!")
	class PlayNewGame{
		PlayGame playGame = new PlayGame();
		int[] gameNumbers;
		private int[] clientNumbers;

		@BeforeEach
		public void generateRandoms(){
			clientNumbers = new GenerateGameNumber(3).generateGameNumber();
			gameNumbers = playGame.getGameNumbers();
		}

		@Test
		@DisplayName("3. 게임 [😊] 정확값을 입력해서 게임에서 승리했을때.")
		public void game_clear_green(){
			// given
			String allMatchNumber = "";

			for(int item : gameNumbers){
				allMatchNumber+=String.valueOf(item);
			}

			// when
			GameHintAndResults results = playGame.playGame(allMatchNumber);
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
			for(int item : clientNumbers){
				randomNumbers+=String.valueOf(item);
			}
			// when
			GameHintAndResults results = playGame.playGame(randomNumbers);
			// than
			if(results.isFinish()){
				assertThat(results)
						.extracting("hint")
						.isEqualTo("스트라이크 3볼 ");
			}
			if(!results.isFinish()){
				assertThat(results.getHint())
						.isIn(
								"스트라이크 1볼 ",
								"스트라이크 2볼 ",
								"1볼 ",
								"2볼 ",
								"3볼 ",
								"스트라이크 1볼 1볼 ",
								"스트라이크 2볼 1볼 ",
								"스트라이크 1볼 2볼 "
						);
			}
		}
	}
}