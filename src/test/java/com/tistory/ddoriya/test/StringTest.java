/*
 * @(#) StringTest.java 2021. 04. 24.
 *
 */
package com.tistory.ddoriya.test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author 이상준
 */
public class StringTest {
	@Test
	@DisplayName("1,2을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
	public void splitContainsTest1() {
		assertThat("1,2".split(",")).contains("1", "2");
	}

	@Test
	@DisplayName("1을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
	public void splitContainsTest2() {
		assertThat("1,".split(",")).containsExactly("1");
	}

	@Test
	@DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 1,2를 반환")
	public void substringTest() {
		String testStr = "(1,2)";
		assertThat(testStr.substring(testStr.indexOf("(") + 1, testStr.indexOf(")"))).isEqualTo("1,2");
	}

	@Test
	@DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져와 IndexOutOfBoundsException 발생 학습 테스트")
	public void IndexOutOfBoundsExceptionTest() {
		assertThatThrownBy(() -> {
			String testStr = "abc";
			testStr.charAt(4);
		}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: 4");

		assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
			String testStr = "abc";
			testStr.charAt(4);
		}).withMessageMatching("String index out of range: 4");
	}
}