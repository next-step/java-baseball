import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayBaseBallTest {

	// 1부터 9까지 서로 다른 3자리 수
	@DisplayName("서로 다른 3자리의 수 : 한자리 수는 1부터 9까지 이다")
	@Test
	void getThreeDifferentNumberOneToNine() {
		int number = 1;
		int resultNumber = 0;
		if (number > 0 && number < 10) {
			resultNumber = number;
		}
		assertThat(resultNumber).isEqualTo(number);
	}

	@DisplayName("서로 다른 3자리 수 : 1번째 자리 수가 추가 되는지")
	@Test
	void getThreeDifferentNumberOne() {
		String selectString = "";
		int number = 2;
		int index = selectString.indexOf(String.valueOf(number));
		if (index < 0) {
			selectString += number;
		}
		assertThat(selectString).isEqualTo("2");
	}

	@DisplayName("서로 다른 3자리 수 :2번째 자리 수에 다른 수가 추가 되는지")
	@Test
	void getThreeDifferentNumberTwo() {
		String selectString = "2";
		int number = 4;
		int index = selectString.indexOf(String.valueOf(number));
		if (index < 0) {
			selectString += number;
		}
		assertThat(selectString).isEqualTo("24");
	}

	@DisplayName("서로 다른 3자리 수 :3번째 자리 수에 다른 수가 추가 되는지")
	@Test
	void getThreeDifferentNumberThree() {
		String selectString = "24";
		int number = 5;
		int index = selectString.indexOf(String.valueOf(number));
		if (index < 0) {
			selectString += number;
		}
		assertThat(selectString).isEqualTo("245");
	}

}