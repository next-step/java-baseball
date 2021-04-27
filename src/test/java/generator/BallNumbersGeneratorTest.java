package generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.right42.domain.BallNumber;
import me.right42.domain.BallNumbers;
import me.right42.generator.BallNumbersGenerator;
import me.right42.generator.FixedBallNumberGenerator;
import me.right42.generator.RandomBallNumberGenerator;

class BallNumbersGeneratorTest {

	@Test
	void randomNumberTest(){
		BallNumbersGenerator generator = new RandomBallNumberGenerator();

		BallNumbers ballNumbers = generator.generate();

		assertThat(ballNumbers.getBalls()).isNotNull();
		assertThat(ballNumbers.getBalls().size()).isEqualTo(3);
	}

	@Test
	void fixedNumberTest(){
		BallNumbersGenerator generator = new FixedBallNumberGenerator("123");

		BallNumbers ballNumbers = generator.generate();

		assertThat(ballNumbers.getBalls()).isNotNull();
		assertThat(ballNumbers.getBalls().size()).isEqualTo(3);
		assertThat(ballNumbers.getBalls()).containsExactly(new BallNumber(1), new BallNumber(2), new BallNumber(3));
	}
}
