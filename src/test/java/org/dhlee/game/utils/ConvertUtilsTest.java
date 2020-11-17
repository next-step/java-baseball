package org.dhlee.game.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertUtilsTest {

	@Test
	@DisplayName("스트링 리스트 변환 테스트")
	public void StringToIntListTest() {
		Integer[] numbers = {1, 2, 3};
		assertThat(ConvertUtils.StringToIntList("12345", 3)).isEqualTo(Arrays.asList(numbers));
		Integer[] numbers2 = {1, 3, 5, 6};
		assertThat(ConvertUtils.StringToIntList("1356", 4)).isEqualTo(Arrays.asList(numbers2));
		Integer[] numbers3 = {9, 8, 6, 2, 1};
		assertThat(ConvertUtils.StringToIntList("98621", 5)).isEqualTo(Arrays.asList(numbers3));

	}
}
