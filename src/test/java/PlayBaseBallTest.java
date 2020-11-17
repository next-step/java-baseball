import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

	@DisplayName("입력받은 수가 3자리 인지")
	@Test
	void inputValueCaseOne() {
		String intputString = "123";
		boolean cheked = true;
		if (intputString.length() != 3) {
			cheked = false;
		}
		assertThat(cheked).isTrue();
	}

	@DisplayName("입력받은 수가 글자가 있는 경우")
	@Test
	void inputValueCaseTwo() {
		String intputString = "1ㄲㄴ";
		boolean isNumber = false;
		try {
			Integer.parseInt(intputString);
			isNumber = true;
		} catch (NumberFormatException e) {

		}
		assertThat(isNumber).isFalse();
	}

	@DisplayName("입력받은 수가 숫자인 경우")
	@Test
	void inputValueCaseThree() {
		String intputString = "111";
		boolean isNumber = false;
		try {
			Integer.parseInt(intputString);
			isNumber = true;
		} catch (NumberFormatException e) {

		}
		assertThat(isNumber).isTrue();
	}

	@DisplayName("입력받은 3자리 수 중복된 숫자가 있는 경우")
	@Test
	void inputValueCaseFour() {
		String intputString = "111";
		Set resultSet = new HashSet<>();
		for (int i = 0; i < intputString.length(); i++) {
			resultSet.add(new Character(intputString.charAt(i)));
		}
		int size = resultSet.size();
		assertThat(size).isEqualTo(1);
	}

	@DisplayName("입력받은 3자리 수 중복된 숫자가 없는 경우")
	@Test
	void inputValueCaseFive() {
		String intputString = "123";
		Set resultSet = new HashSet<>();
		for (int i = 0; i < intputString.length(); i++) {
			resultSet.add(new Character(intputString.charAt(i)));
		}
		int size = resultSet.size();
		assertThat(size).isEqualTo(3);
	}


	@DisplayName("입력받은 수가 3자리 에 0이 있는지 확인")
	@Test
	void inputValueCaseSix() {
		String intputString = "023";
		int index = intputString.indexOf("0");
		boolean isZero = true;
		if (index == -1) {
			isZero = false;
		}
		assertThat(isZero).isTrue();
	}

}