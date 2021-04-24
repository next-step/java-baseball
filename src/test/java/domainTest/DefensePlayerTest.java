package domainTest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import domain.DefensePlayer;
import domain.Numbers;

public class DefensePlayerTest {

	@Test
	void testGeneratedNumbers(){
		//Given
		DefensePlayer defensePlayer = new DefensePlayer();

		//when
		Numbers numbers = defensePlayer.decideAnswerNumber();

		//then
		assertThat(numbers.getDigits().size()).isEqualTo(Numbers.MAX_SIZE);
		assertThat(numbers.getDigits().get(0)).isNotEqualTo(numbers.getDigits().get(1))
			                                  .isNotEqualTo(numbers.getDigits().get(2));
		assertThat(numbers.getDigits().get(1)).isNotEqualTo(numbers.getDigits().get(2));
	}

}
