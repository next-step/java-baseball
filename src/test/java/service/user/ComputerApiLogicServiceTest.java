package service.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import model.entity.Baseball;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ComputerApiLogicServiceTest {
	private final Set<Integer> numberSet = new HashSet<>();
	Baseball baseball;

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
		List<Integer> inputNumber = new ArrayList<>();
		List<Integer> randomNumber = new ArrayList<>();

		inputNumber.add(1);
		inputNumber.add(5);
		inputNumber.add(7);

		randomNumber.add(1);
		randomNumber.add(5);
		randomNumber.add(6);

		for(int i=0; i<inputNumber.size(); i++) {
			baseball.setStrike(baseball.getStrike() + calcStrikeCount(inputNumber, randomNumber, i));
		}

		assertThat(baseball.getStrike()).isEqualTo(2);
	}

	public int calcStrikeCount(List<Integer> inputNumber, List<Integer> randomNumber, int idx) {
		int cnt = 0;
		if(inputNumber.get(idx).equals(randomNumber.get(idx))) {
			cnt = 1;
		}

		return cnt;
	}

	@Test
	@DisplayName("다른 자리의 같은 숫자가 있는지 확인 : 볼")
	public void calcBallTest() {
		baseball = new Baseball();
		List<Integer> inputNumber = new ArrayList<>();
		List<Integer> randomNumber = new ArrayList<>();

		inputNumber.add(1);
		inputNumber.add(5);
		inputNumber.add(7);

		randomNumber.add(1);
		randomNumber.add(5);
		randomNumber.add(7);

		for(int i=0; i<inputNumber.size(); i++) {
			baseball.setBall(baseball.getBall()+calcStrikeCount(inputNumber, randomNumber, i));
		}

		assertThat(baseball.getBall()).isEqualTo(3);
	}

	public int calcBallCount(List<Integer> inputNumber, List<Integer> randomNumber, int idx) {
		int ball = 0;
		for(int i=0; i<3; i++) {
			if(idx != i && inputNumber.get(idx).equals(randomNumber.get(i))) {
				ball=+1;
			}
		}

		return ball;
	}

	@Test
	@DisplayName("낫싱 확인")
	public void checkNothingTest() {
		baseball.setStrike(0);
		baseball.setBall(0);
		if(baseball.getStrike() == 0 && baseball.getBall() == 0) {
			assertThat(true).isTrue();
		}
	}

	@Test
	@DisplayName("힌트 출력")
	public void giveHint() {
		List<Integer> inputNumber = new ArrayList<>();
		List<Integer> randomNumber = new ArrayList<>();

		inputNumber.add(1);
		inputNumber.add(5);
		inputNumber.add(7);

		randomNumber.add(1);
		randomNumber.add(7);
		randomNumber.add(5);

		int strike = 0;
		int ball = 0;
		for(int i=0; i<3; i++) {
			strike += calcStrike(inputNumber, randomNumber, i);
			ball += calcBall(inputNumber, randomNumber, i);
		}

		System.out.println(printHintMessage(strike, ball));
		assertThat(strike).isEqualTo(1);
		assertThat(ball).isEqualTo(2);
	}

	public int calcStrike(List<Integer> inputNumber, List<Integer> randomNumber, int i) {
		baseball = new Baseball();
		if(inputNumber.get(i).equals(randomNumber.get(i))) {
			baseball.setStrike(baseball.getStrike() + 1);
		}

		System.out.print(baseball.getStrike());
		return baseball.getStrike();
	}

	public int calcBall(List<Integer> inputNumber, List<Integer> randomNumber, int i) {
		baseball = new Baseball();
		for(int j = 0; j<inputNumber.size(); j++) {
			if(i != j && inputNumber.get(i).equals(randomNumber.get(j))) {
				baseball.setBall(baseball.getBall() + 1);
			}
		}

		return baseball.getBall();
	}

	public String printHintMessage(int strike, int ball) {
		String hint = "";

		if(ball == 0)
			hint = strike + " 스트라이크";
		if(strike == 0)
			hint = ball + " 볼";
		if(strike > 0 && ball > 0)
			hint = strike + " 스트라이크 " + ball + " 볼";
		if(checkNothing())
			hint = "낫싱";

		return hint;
	}

	public boolean checkNothing() {
		baseball = new Baseball();

		if(baseball.getStrike() == 0 && baseball.getBall() == 0) {
			return true;
		}
		return false;
	}
}
