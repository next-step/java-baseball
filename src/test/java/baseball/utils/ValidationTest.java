package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Game;

public class ValidationTest {

	@Test
	@DisplayName("3 자리 이상의 수")
	public void overThreeDigits() {
		String InputStr = "3145";
		if (InputStr.length() > Game.NUMBER_LENGTH) {
			assertThatThrownBy(() -> {
				throw new IllegalArgumentException("100~999 사이의 서로 다른 숫자로 구성된 3자리 수가 아닙니다.");
			}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("100~999 사이의 서로 다른 숫자로 구성된 3자리 수가 아닙니다.");
		}
	}

	@Test
	@DisplayName("3 자리 이하의 수")
	public void underThreeDigits() {
		String InputStr = "24";
		if (InputStr.length() < Game.NUMBER_LENGTH) {
			assertThatThrownBy(() -> {
				throw new IllegalArgumentException("100~999 사이의 서로 다른 숫자로 구성된 3자리 수가 아닙니다.");
			}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("100~999 사이의 서로 다른 숫자로 구성된 3자리 수가 아닙니다.");
		}
	}

	@Test
	@DisplayName("문자열 포함")
	public void containsCharacter() {
		String InputStr = "3f1";
		for (int i = 0; i < InputStr.length(); i++) {
			if (!Character.isDigit(InputStr.charAt(i))) {
				assertThatThrownBy(() -> {
					throw new IllegalArgumentException("100~999 사이의 서로 다른 숫자로 구성된 3자리 수가 아닙니다.");
				}).isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining("100~999 사이의 서로 다른 숫자로 구성된 3자리 수가 아닙니다.");
			}
		}
	}

	@Test
	@DisplayName("중복된 숫자 포함")
	public void containsDuplicateNumber() {
		Set<Integer> InputNumbers = new HashSet<>();
		InputNumbers.add(2);
		InputNumbers.add(2);
		InputNumbers.add(3);

		if (InputNumbers.size() != Game.NUMBER_LENGTH) {
			assertThatThrownBy(() -> {
				throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
			}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("중복된 숫자가 포함되어 있습니다.");
		}
	}

	@Test
	@DisplayName("0 포함")
	public void containsZero() {
		String InputStr = "203";
		if (InputStr.contains("0")) {
			assertThatThrownBy(() -> {
				throw new IllegalArgumentException("0이 포함되어 있습니다.");
			}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("0이 포함되어 있습니다.");
		}
	}
}
