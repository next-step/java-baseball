import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

	@DisplayName("입력받은 수를 정수형 으로 변경한다.")
	@Test
	void compareNumber() {
		String value = "123";
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += Character.getNumericValue(value.charAt(i));
		}
		assertThat(sum).isEqualTo(6);
	}

	@DisplayName("입력받은 수 정수형 Array로 변경한다.")
	@Test
	void changeNumberArray() {
		String value = "123";
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			arrayList.add(Character.getNumericValue(value.charAt(i)));
		}
		assertThat(arrayList.size()).isEqualTo(3);
	}

	@DisplayName("값을 비교해서 같은 위치에 있으면 스트라이크")
	@Test
	void countStrike() {
		ArrayList<Integer> computer = new ArrayList<>();
		computer.add(1);
		computer.add(2);
		computer.add(3);
		ArrayList<Integer> user = new ArrayList<>();
		user.add(1);
		user.add(2);
		user.add(3);
		Iterator<Integer> computerIterator = computer.iterator();
		Iterator<Integer> userIterator  = user.iterator();
		int strike = 0;
		while (computerIterator.hasNext()) {
			int computerNum = computerIterator.next();
			int userNum = userIterator.next();
			if (computerNum == userNum) {
				strike++;
			}
		}
		assertThat(strike).isEqualTo(3);
	}

	@DisplayName("값이 다른 위치에 있으면 Ball")
	@Test
	void countBall() {
		ArrayList<Integer> computer = new ArrayList<>();
		computer.add(1);
		computer.add(2);
		computer.add(3);
		ArrayList<Integer> user = new ArrayList<>();
		user.add(3);
		user.add(5);
		user.add(6);
		Iterator<Integer> computerIterator = computer.iterator();
		Iterator<Integer> userIterator  = user.iterator();
		int ball = 0;
		while (computerIterator.hasNext()) {
			int computerNum = computerIterator.next();
			int userNum = userIterator.next();
			if (computerNum != userNum) {
				if (user.contains(computerNum)) {
					ball++;
				}
			}
		}
		assertThat(ball).isEqualTo(1);
	}

	@DisplayName("같은 수가 없으면 Nothing")
	@Test
	void countNothing() {
		ArrayList<Integer> computer = new ArrayList<>();
		computer.add(1);
		computer.add(2);
		computer.add(3);
		ArrayList<Integer> user = new ArrayList<>();
		user.add(7);
		user.add(5);
		user.add(6);
		Iterator<Integer> computerIterator = computer.iterator();
		Iterator<Integer> userIterator  = user.iterator();
		int nothing = 0;
		while (computerIterator.hasNext()) {
			int computerNum = computerIterator.next();
			int userNum = userIterator.next();
			if (computerNum != userNum) {
				if (!user.contains(computerNum)) {
					nothing++;
				}
			}
		}
		assertThat(nothing).isEqualTo(3);
	}

}