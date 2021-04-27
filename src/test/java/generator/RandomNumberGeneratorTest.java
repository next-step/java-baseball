package generator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

	@Test
	@DisplayName("랜덤한 세자리수 생성")
	public void randomNumber(){
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		List<Integer> resultNumber = randomNumberGenerator.getTargetNumber();
		assertThat(resultNumber.size()).isEqualTo(3);
	}
}
