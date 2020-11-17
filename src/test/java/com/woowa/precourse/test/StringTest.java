package com.woowa.precourse.test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class StringTest { 
	@Test
	@DisplayName(value = "'1,2'을 ',' 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
	public void requirement1() {
		String input = "1,2";
		String[] result = input.split(",");
		String[] expected = new String[] {"1", "2"};
		assertThat(result).contains("1");
		assertThat(result).contains("2");
		assertThat(result).containsExactly(expected);
	}

	@Test
	@DisplayName(value = "'1'을 ',' 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
	public void requirement1_2() {
		String input = "1";
		String[] result = input.split(",");
		String[] expected = new String[] {"1"};
		assertThat(result).contains("1");
		assertThat(result).containsExactly(expected);
	}

	@Test
	@DisplayName(value = "'(1,2)'값이 주어졌을 때 String의 substring() 메소드를 활용해 '()'을 제거하고'1,2'를 반환하는지 테스트")
	public void requirement2() {
		String input = "(1,2)";
		String result = input.substring(1, input.indexOf(")"));
		String expected = "1,2";
		assertThat(result).contains("1");
		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName(value = "'abc'값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 잘 가져오는지 테스트")
	public void requirement3_1() {
		String input = "abc";
		char a = input.charAt(0);
		char b = input.charAt(1);
		char c = input.charAt(2);
		char expectedA = 'a';
		char expectedB = 'b';
		char expectedC = 'c';
		assertThat(expectedA).isEqualTo(a);
		assertThat(expectedB).isEqualTo(b);
		assertThat(expectedC).isEqualTo(c);
	}

	@Test
	@DisplayName(value = "String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면"
			+ "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
	public void requirement3_2() {
		String input = "abc";
		assertThatThrownBy(() -> input.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class).
			hasMessageContaining("String index out of range: 3");
	}
}