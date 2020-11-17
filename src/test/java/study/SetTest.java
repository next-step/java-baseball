package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
	
	private Set<Integer> numbers;
	
	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}
	
	@Test
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
	public void setSizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}
	
	@DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	public void containsTest(int value){
		assertThat(numbers.contains(value)).isTrue();
	}
	
	@DisplayName("입력 값에 따라 결과값이 다른 경우에 대한 테스트도 가능하도록 설정")
	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,ture"})
	public void containsCaseTest(int value, boolean status){
		boolean flag = numbers.contains(value);
		assertThat(status).isEqualTo(flag);
	}
	
}
