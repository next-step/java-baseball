package exam.baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exam.baseball.BaseBallGame.BaseBallScore;

class TestBaseBallGame {

	@Test
	void test_정답을_맞추면_게임이_종료되고_종료_메시지가_출력된다() {
		StringBuilder builder = new StringBuilder();
		String fixedAnswer = "123";
		BaseBallGame game = new BaseBallGame(()->fixedAnswer);
	
		String[] inputs = {"456", "789", "321", "132", fixedAnswer};
		final List<String> inputList = new ArrayList<>();
		for (String input : inputs) {
			inputList.add(input);
		}
		
		game.setInputMethod(()->{
			return inputList.remove(0);
		});
		game.setPrintMethod(builder::append);
		game.start();
		
		assertThat(builder.toString())
			.endsWith(BaseBallGame.GAME_FINISH_MSG);
	}
	
	@ParameterizedTest
	@CsvSource(value = {
		"124:2:0:2 스트라이크",
		"142:1:1:1 스트라이크 1 볼",
		"132:1:2:1 스트라이크 2 볼",
		"245:0:1:1 볼",
		"236:0:2:2 볼",
		"312:0:3:3 볼",
		"456:0:0:낫싱",
		"123:3:0:3 스트라이크"
	}, delimiter = ':')
	void test_스코어에_맞는_메시지가_출력된다(String input, 
			int strikeCount, int ballCount, String expectedText) {
		
		String fixedAnswer = "123";
		BaseBallGame game = new BaseBallGame(()->fixedAnswer);
		BaseBallScore score = game.match(fixedAnswer, input);
		String result = game.makeScoreText(score);
		
		Executable equalToStrike = ()->assertThat(score.getStrike())
				.isEqualTo(strikeCount);
		Executable equalToBall = ()->assertThat(score.getBall())
				.isEqualTo(ballCount);
		Executable containMsg = () -> assertThat(result)
				.contains(expectedText); 
		
		assertAll(equalToStrike, equalToBall, containMsg);
	}
	
	
}
