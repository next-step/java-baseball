package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class PitcherTest {
	@DisplayName("컴퓨터가 중복되지 않는 3개의 랜덤 숫자를 반환한다")
	@RepeatedTest(100)
	void testPitches() {
		Pitcher pitcher = new Pitcher();
		Set<Integer> pitches = pitcher.pitches(3);

		assertThat(pitches).hasSize(3)
			.doesNotHaveDuplicates()
			.doNotHave(new Condition<>(pitch -> pitch < 1 || 9 < pitch, "똥볼"));
	}
}
