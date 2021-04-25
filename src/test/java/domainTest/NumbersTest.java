package domainTest;

import org.assertj.core.error.ShouldBeFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.List;

import domain.Numbers;

public class NumbersTest {


	@DisplayName("digits 리스트 내부의 숫자들이 순서대로 담겨있는지 점검")
	@Test
	void getDigits_ContainsNumberInExactOrder_returnTrue(){
		//Given
		Numbers numbers = new Numbers();

		//when
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);

		//then
		assertThat(numbers.getDigits()).containsExactly(1,3,5);
	}


	@DisplayName("digits 리스트의 크기가 3을 넘으면 숫자 추가 불가능")
	@Test
	void add_SizeIsAlreadyThree_cannotAdd(){
		//Given
		Numbers numbers = new Numbers();

		//when
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);

		numbers.add(4);

		//then
		assertThat(numbers.getDigits().size()).isEqualTo(3);
	}

	@DisplayName("1~9사이의 숫자가 아니면 리스트에 추가되지 않음")
	@Test
	void add_OutofRangeNumber_notAdded(){
		//Given
		Numbers numbers = new Numbers();

		//when
		numbers.add(1);
		numbers.add(2);
		numbers.add(12);

		//then
		assertThat(numbers.getDigits().size()).isEqualTo(2);
	}

	@DisplayName("Digits 리스트의 사이즈를 리턴함")
	@Test
	void length_returnLengthofDigits(){
		//Given
		Numbers numbers = new Numbers();

		//when
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		List<Integer> digitAnswer = numbers.getDigits();

		//then
		assertThat(numbers.length()).isEqualTo(digitAnswer.size());
	}
}
