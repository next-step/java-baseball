package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberFactoryTest {

	private RandomNumberFactory factory;

	@BeforeEach
	public void setUp() {
		factory = new RandomNumberFactory();
	}

	@DisplayName("랜던으로 생성된 숫자의 길이가 3자리 인지 확인")
	@Test
	public void length() {
		String number = factory.make();

		assertThat(number.length()).isEqualTo(3);
	}

	@DisplayName("랜덤으로 생성된 3개의 숫자가 중복되지 않는지 확인")
	@Test
	public void make() {
		String number = factory.make();

		char num1 = number.charAt(0);
		char num2 = number.charAt(1);
		char num3 = number.charAt(2);

		assertThat(num1).isNotEqualTo(num2);
		assertThat(num2).isNotEqualTo(num3);
		assertThat(num1).isNotEqualTo(num3);
	}
}
