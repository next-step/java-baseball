package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import utils.ListUtil;

class TargetTest {

	Target sut;

	@BeforeEach
	void setUp() {
		sut = Target.of(ListUtil.convertStrToList("123"));
	}

	@ParameterizedTest(name = "[{index}] 시스템이 생성한 {argumentsWithNames}이 3자리 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
	@ValueSource(strings = {"", "1", "12", "1234", "12345"})
	void 사용자_값이_3자리_숫자가_아닐경우_IllegalArgumentException_을_던진다(String target) {
		assertThatThrownBy(() -> sut.setValue(ListUtil.convertStrToList(target)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("3자리 숫자만 허용합니다.");
	}

	@ParameterizedTest(name = "[{index}] 사용자값 {argumentsWithNames}가 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
	@ValueSource(strings = {"a", "abc", "abc123", "1qa"})
	void 사용자_값이_숫자가_아닐경우_IllegalArgumentException_을_던진다(String target) {
		assertThatThrownBy(() -> sut.setValue(ListUtil.convertStrToList(target)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("3자리 숫자만 허용합니다.");
	}
}