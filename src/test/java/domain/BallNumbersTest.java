package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.right42.domain.BallMatchResult;
import me.right42.domain.BallNumbers;
import me.right42.exception.BallNumberDuplicationException;

class BallNumbersTest {

	@Test
	@DisplayName("잘못된 볼사이즈 입력 테스트")
	void ballSizeValidateTest(){
		String value = "12";
		List<Integer> numbers = Arrays.asList(1, 2);
		String message = "볼 사이즈는 3개 입니다.";


		assertThatThrownBy(() -> BallNumbers.create(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(message);


		assertThatThrownBy(() -> BallNumbers.create(numbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(message);
	}

	@Test
	@DisplayName("중복된 값 입력 테스트")
	void validateBallNumbersTest(){
		String value = "122";
		List<Integer> numbers = Arrays.asList(1, 2, 2);
		String message = "볼 값은 중복불가 입니다.";

		assertThatThrownBy(() -> BallNumbers.create(value))
			.isInstanceOf(BallNumberDuplicationException.class)
			.hasMessage(message);

		assertThatThrownBy(() -> BallNumbers.create(numbers))
			.isInstanceOf(BallNumberDuplicationException.class)
			.hasMessage(message);
	}

	@Test
	@DisplayName("같은 BallNumbers compareTo 테스트")
	void compareToTest(){
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		BallNumbers ballNumbers1 = BallNumbers.create(numbers);
		BallNumbers ballNumbers2 = BallNumbers.create(numbers);

		BallMatchResult ballMatchResult = ballNumbers1.compareTo(ballNumbers2);

		assertThat(ballMatchResult.isGameComplete()).isTrue();
		assertThat(ballMatchResult.getStrikeCount()).isEqualTo(3);
		assertThat(ballMatchResult.getBallCount()).isEqualTo(0);
		assertThat(ballMatchResult.getNothingCount()).isEqualTo(0);
	}

	@Test
	@DisplayName("다른 BallNumbers compareTo 테스트")
	void anotherCompareToTest(){
		BallNumbers ballNumbers1 = BallNumbers.create(Arrays.asList(1, 2, 3));
		BallNumbers ballNumbers2 = BallNumbers.create(Arrays.asList(1, 4, 2));

		BallMatchResult ballMatchResult = ballNumbers1.compareTo(ballNumbers2);

		assertThat(ballMatchResult.isGameComplete()).isFalse();
		assertThat(ballMatchResult.getStrikeCount()).isEqualTo(1);
		assertThat(ballMatchResult.getBallCount()).isEqualTo(1);
		assertThat(ballMatchResult.getNothingCount()).isEqualTo(1);
	}

	@Test
	@DisplayName("같은 BallNumbers equals 테스트")
	void equalsTest(){
		String ballNumbers = "123";

		BallNumbers ballNumbers1 = BallNumbers.create(ballNumbers);
		BallNumbers ballNumbers2 = BallNumbers.create(ballNumbers);

		assertThat(ballNumbers1).isEqualTo(ballNumbers2);
	}

	@Test
	@DisplayName("다른 BallNumbers equals 테스트")
	void NotEqualsTest(){
		String numbers1 = "123";
		String numbers2 = "456";

		BallNumbers ballNumbers1 = BallNumbers.create(numbers1);
		BallNumbers ballNumbers2 = BallNumbers.create(numbers2);

		assertThat(ballNumbers1).isNotEqualTo(ballNumbers2);
	}
}
