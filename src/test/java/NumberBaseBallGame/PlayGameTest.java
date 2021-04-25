package NumberBaseBallGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayGameTest {

	@Test
	@DisplayName("[😊] 게임 동작 테스트")
	public void 게임동작테스트(){
	    // given
		PlayGame playGame = new PlayGame();;

		int[] gameNumbers = playGame.getGameNumbers();

		System.out.println(">> "+ Arrays.toString(gameNumbers));
		// when
		GameHintAndResults results = playGame.playGame("123");
		// than
		assertThat(results)
				.isNotNull()
				;
	}

	@Test
	@DisplayName("[X] 게임 입력값 벨리데이션체크 숫자이외의 문자를 넣았을때.")
	public void 게임_입력값_벨리데이션체크_숫자이외_RED(){
		// given
		PlayGame playGame = new PlayGame();;

		// when
		assertThatThrownBy(() -> {playGame.playGame("꺄꼬");})
		// than
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복되지 않는 숫자 3자리를 입력해야합니다.")
		;
	}
	@Test
	@DisplayName("[X] 게임 입력값 벨리데이션체크 3자리보다 길게 넣았을때.")
	public void 게임_입력값_벨리데이션체크_초과길_RED(){
		// given
		PlayGame playGame = new PlayGame();;

		// when
		assertThatThrownBy(() -> {playGame.playGame("1234");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("중복되지 않는 숫자 3자리를 입력해야합니다.")
		;
	}

	@Test
	@DisplayName("[X] 게임 입력값 벨리데이션체크 중복숫자 넣았을때.")
	public void 게임_입력값_벨리데이션체크_중복숫자_RED(){
		// given
		PlayGame playGame = new PlayGame();

		// when
		assertThatThrownBy(() -> {playGame.playGame("122");})
				// than
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("중복되지 않는 숫자 3자리를 입력해야합니다.")
		;
	}

	@Test
	@DisplayName("[😊] 정확값을 입력해서 게임에서 승리했을때.")
	public void game_clear_green(){
		// given
		PlayGame playGame = new PlayGame();
		// when
		String allMatchNumber = "";
		int[] gameNumbers = playGame.getGameNumbers(); // 대결용 생성 숫자

		for(int item : gameNumbers){
			allMatchNumber+=String.valueOf(item);
		}
		GameHintAndResults results = playGame.playGame(allMatchNumber);
		// than
		assertThat(results)
				.extracting("finish")
				.isEqualTo(true)
				;

	}

	@Test
	public void game(){
	    // given
	    // when
	    // than
	}
}