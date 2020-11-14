package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallCountBallResolverTest {
	private String answer;

	@BeforeEach
	public void setUp(){
		answer = "713";
	}

	@ParameterizedTest
	@CsvSource(value = {
		"000:0S0B",
		"300:0S1B",
		"370:0S2B",
		"137:0S3B"
	}, delimiter = ':')
	public void test(final String input, final String expected){
		final BallCountResolver resolver = new BallCountBallResolver();
		final BallCount ballCount = new BallCount();

		for(int i = 0; i < 3; i++){
			if(resolver.isMatch(i, input, answer)) {
				resolver.resolve(ballCount);
			}
		}

		assertThat(ballCount.toString()).isEqualTo(expected);
	}
}
