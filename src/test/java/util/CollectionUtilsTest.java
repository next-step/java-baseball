package util;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionUtilsTest {

	@Test
	@DisplayName("입력한 collection 이 empty 인 경우, true 를 반환한다")
	void returnTrue_whenCollectionIsEmpty() {
		// given
		List<Integer> input = new ArrayList<>();

		// when
		boolean result = CollectionUtils.isEmpty(input);

		// then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("입력한 collection 이 empty 가 아닌 경우, false 를 반환한다")
	void returnFalse_whenCollectionIsNotEmpty() {
		// given
		List<Integer> input = Collections.singletonList(1);

		// when
		boolean result = CollectionUtils.isEmpty(input);

		// then
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("입력한 collection 이 null 경우, true 를 반환한다")
	void returnTrue_whenCollectionIsNull() {
		// given

		// when
		boolean result = CollectionUtils.isEmpty(null);

		// then
		assertThat(result).isTrue();
	}

}
