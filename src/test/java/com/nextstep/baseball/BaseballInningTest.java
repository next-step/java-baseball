package com.nextstep.baseball;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballInningTest {
	private BaseballInning inning;
	
	ArrayList<Integer> getPitchingstrategy() {
		ArrayList<Integer> pitchingstrategy = null;
		try {
			Field f = inning.getClass().getDeclaredField("pitchingstrategy");
			f.setAccessible(true);
			pitchingstrategy = (ArrayList<Integer>)f.get(inning);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		ArrayList<Integer> copy = new ArrayList<Integer>();
		copy.addAll(pitchingstrategy);
		return copy;
	}

	int arrayToInt(ArrayList<Integer> numbers) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			result += numbers.get(i) * Math.pow(10, 2 - i);
		}
		return result;
	}
	
	int getRadomNumber() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		int num = random.nextInt(9) + 1;
		return num;
	}

	int getNotContainNumber(ArrayList<Integer> execept) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		numbers.addAll(execept);
		int num = 0;
		while (numbers.size() != (execept.size() + 1)) {
			num = getRadomNumber();
			numbers.add(num);
		}
		return num;
	}

	@BeforeEach
	void setup() {
		inning = new BaseballInning();
	}

	@Test
	@DisplayName("객체 생성 확인")
	void create() {
		assertThat(inning).isNotNull();
	}
	
	@Test
	@DisplayName("게임이 정상적으로 시작되었는지 확인")
	void start() {
		int testcase = 789;
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo(inning.NOT_STARTED);
		inning.start();
		answer = inning.pitchAndHit(testcase);
		assertThat(answer).isNotEqualTo(inning.NOT_STARTED);
		assertThat(answer).isNotEqualTo(inning.NOT_VALID_PARAM);
	}
	
	@Test
	@DisplayName("1볼")
	void oneball() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int n1 = getNotContainNumber(execepts);
		execepts.add(n1);
		int n2 = getNotContainNumber(execepts);
		int testcase = execepts.get(0) + (n1 * 10) + (n2 * 100);
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo("1" + inning.BALL);
	}

	
	@Test
	@DisplayName("2볼")
	void twoball() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int n1 = getNotContainNumber(execepts);
		int testcase = (arrayToInt(getPitchingstrategy()) / 10) + (n1 * 100);
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo("2" + inning.BALL);
	}
	
	@Test
	@DisplayName("3볼")
	void threeball() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int testcase = execepts.get(2) * 100 + execepts.get(0) * 10 + execepts.get(1);
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo("3" + inning.BALL);
	}
	
	@Test
	@DisplayName("낫싱")
	void nothing() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int testcase = 0;
		for (int i = 0; i < 3; i++) {
			int n = getNotContainNumber(execepts);
			testcase += (n * Math.pow(10, i));
			execepts.add(n);
		}
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo(inning.NOTHING);
	}
	
	@Test
	@DisplayName("1스트레이크1볼")
	void onestrikeOneball() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int n1 = getNotContainNumber(execepts);
		int testcase = execepts.get(0) * 100 + execepts.get(2) * 10 + n1;
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo("1" + inning.STRIKE + "1" + inning.BALL);
	}
	
	@Test
	@DisplayName("1스트레이크2볼")
	void onestrikeTwoball() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int testcase = execepts.get(0) * 100 + execepts.get(2) * 10 + execepts.get(1);
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo("1" + inning.STRIKE + "2" + inning.BALL);
	}
	
	@Test
	@DisplayName("1스트레이크")
	void onestrike() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int testcase = execepts.get(0) * 100;
		for (int i = 0; i < 2; i++) {
			int n = getNotContainNumber(execepts);
			testcase += Math.pow(10, i) * n;
			execepts.add(n);
		}
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo("1" + inning.STRIKE);
	}
	
	@Test
	@DisplayName("2스트레이크")
	void twostrike() {
		inning.start();
		ArrayList<Integer> execepts = getPitchingstrategy();
		int testcase = execepts.get(0) * 100 + execepts.get(1) * 10 + getNotContainNumber(execepts);
		String answer = inning.pitchAndHit(testcase);
		assertThat(answer).isEqualTo("2" + inning.STRIKE);
	}
	
	@Test
	@DisplayName("3스트레이크")
	void threestrike() {
		inning.start();
		String answer = inning.pitchAndHit(arrayToInt(getPitchingstrategy()));
		assertThat(answer).isEqualTo("3" + inning.STRIKE);
	}
	
	@Test
	@DisplayName("3스트라이크로 종료 여부 확인")
	void end() {
		inning.start();
		boolean isEnd = inning.isEnd();
		assertThat(isEnd).isEqualTo(false);
		int pitchingstrategy = arrayToInt(getPitchingstrategy());
		inning.pitchAndHit(pitchingstrategy);
		isEnd = inning.isEnd();
		assertThat(isEnd).isEqualTo(true);
	}
}
