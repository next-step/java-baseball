package service.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ComputerApiLogicServiceTest {
	Set<Integer> numberSet = new HashSet<>();

	@Test
	@DisplayName("셋을 리스트로 변경")
	public void setToList() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);

		List<Integer> list = new ArrayList<>(set);

		for (Integer num : list) {
			assertThat(num).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(3);
		}
	}

	@Test
	@DisplayName("문자열을 리스트로 변경")
	public void stringToList() {
		String inputNumber = "123";
		List<Integer> inputNumberList = new ArrayList<>();

		for(int i=0; i<inputNumber.length(); i++) {
			inputNumberList.add(Integer.parseInt(inputNumber.substring(i,i+1)));
		}

		assertThat(inputNumberList).contains(1,2,3);
	}

	@DisplayName("중복 되지 않는 랜덤 숫자 생성")
	@RepeatedTest(10)
	public void makeRandomNumber() {
		while (numberSet.size() < 3) {
			numberSet.add((int) (Math.random() * 9 + 1));
		}

		assertThat(numberSet.size()).isEqualTo(3);
		for (int number : numberSet) {
			assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
		}
	}

	@Test
	@DisplayName("같은 자리의 같은 숫자 있는지 확인 : 스트라이크")
	public void calcStrikeTest() {
		List<Integer> inputNumberList = new ArrayList<>();
		List<Integer> randomNumberList = new ArrayList<>();
		int strike = 0;

		inputNumberList.add(1);
		inputNumberList.add(5);
		inputNumberList.add(7);

		randomNumberList.add(1);
		randomNumberList.add(5);
		randomNumberList.add(6);

		for(int i = 0; i < 3; i++) {
			if(inputNumberList.get(i).intValue() == randomNumberList.get(i).intValue())
				strike++;
		}

		assertThat(strike).isEqualTo(2);
	}

	@Test
	@DisplayName("다른 자리의 같은 숫자가 있는지 확인 : 볼")
	public void calcBallTest() {
		List<Integer> inputNumber = new ArrayList<>();
		List<Integer> randomNumber = new ArrayList<>();
		int ball = 0;

		inputNumber.add(1);
		inputNumber.add(5);
		inputNumber.add(7);

		randomNumber.add(7);
		randomNumber.add(1);
		randomNumber.add(5);

		int i = 0;
		int j = 0;
		
		while(i < 3) {
			if(i != j && inputNumber.get(i).intValue() == randomNumber.get(j).intValue())
				ball++;
			
			j++;
			if(j==3) {
				i++;
				j=0;
			}
		}

		assertThat(ball).isEqualTo(3);
	}

	@Test
	@DisplayName("결과 계산")
	public void resultBaseball() {
		List<Integer> inputNumberList = new ArrayList<>();
		List<Integer> randomNumberList = new ArrayList<>();

		inputNumberList.add(1);
		inputNumberList.add(5);
		inputNumberList.add(7);

		randomNumberList.add(1);
		randomNumberList.add(7);
		randomNumberList.add(5);

		int strike = calcStrike(inputNumberList, randomNumberList);
		int ball = calcBall(inputNumberList, randomNumberList);

		assertThat(strike).isEqualTo(1);
		assertThat(ball).isEqualTo(2);
	}

	public int calcStrike(List<Integer> inputNumberList, List<Integer> randomNumberList) {
		int strike = 0;
		for(int i = 0; i < 3; i++) {
			if(inputNumberList.get(i).intValue() == randomNumberList.get(i).intValue())
				strike++;
		}
		
		return strike;
	}

	public int calcBall(List<Integer> inputNumber, List<Integer> randomNumber) {
		int ball = 0;
		int i = 0;
		int j = 0;

		while(i < 3) {
			if(i != j && inputNumber.get(i).intValue() == randomNumber.get(j).intValue())
				ball++;

			j++;
			if(j==3) {
				i++;
				j=0;
			}
		}
		
		return ball;
	}
}
