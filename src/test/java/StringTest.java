import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	/**
	 * "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	 * "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	 */
	@Test
	public void separateSplitTest() {

		// given
		String dualSplitTarget = "1,2";
		String singleSplitTarget = "1";

		// when
		String[] dualSplitResult = dualSplitTarget.split(",");
		String[] singleSplitResult = singleSplitTarget.split(",");

		// then
		// "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인
		assertThat(dualSplitResult[0]).contains("1");
		assertThat(dualSplitResult[1]).contains("2");

		// 1만을 포함하는 배열이 반환되는지
		assertThat(singleSplitResult).containsExactly("1");
	}

	/**
	 * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환
	 * 하도록 구현한다.
	 */
	@Test
	public void subStringTest() {
		// given
		String target = "(1,2)";
		// when
		String result = target.substring(1, target.length() - 1);
		// then
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("문자열 charAt()메소드 인덱스 테스트")
	public void charAtTest() {
		// given
		String target = "abc";

		// when
		char result = target.charAt(1);

		// then
		assertThat(result).isEqualTo('b');

		// 익셉션 테스트
		assertThatThrownBy(() -> {
			target.charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");

		// 다른 방식의 익셉션 테스트
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				target.charAt(3);
			}).withMessageMatching("String index out of range: \\d+");

		// Commit Test222222
	}
}
