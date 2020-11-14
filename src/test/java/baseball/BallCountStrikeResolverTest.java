package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallCountStrikeResolverTest {

	private String answer;

	@BeforeEach
	public void setUp(){
		answer = "713";
	}

	@ParameterizedTest
	@CsvSource(value = {
		"000:0S0B",
		"700:1S0B",
		"710:2S0B",
		"713:3S0B"
	}, delimiter = ':')
	public void test(final String input, final String expected){
		final BallCountResolver resolver = new BallCountStrikeResolver();
		final BallCount ballCount = new BallCount();

		for(int i = 0; i < 3; i++){
			if(resolver.isMatch(i, input, answer)) {
				resolver.resolve(ballCount);
			}
		}

		assertThat(ballCount.toString()).isEqualTo(expected);
	}
}
