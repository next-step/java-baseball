package domainTest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import domain.Numbers;

public class NumbersTest {

	@Test
	void checkOutofRangeTest(){
		//Given
		Numbers numbers = new Numbers();

		//when
		numbers.add(0);
		numbers.add(10);
		numbers.add(12);

		//then
		assertThat(numbers.getDigits().size()).isEqualTo(0);
	}

	@Test
	void checkBetweenRangeTest(){
		//Given
		Numbers numbers = new Numbers();

		//when
		numbers.add(1);
		numbers.add(2);
		numbers.add(9);

		//then
		assertThat(numbers.getDigits().size()).isEqualTo(3);
	}

	@Test
	void checkThrowSizeOverExceptionTest(){
		//Given
		Numbers numbers = new Numbers();

		//when
		numbers.add(1);
		numbers.add(2);
		numbers.add(9);

		//then
		assertThatThrownBy(()->{numbers.add(4);}).isInstanceOf(IndexOutOfBoundsException.class);
	}
}
