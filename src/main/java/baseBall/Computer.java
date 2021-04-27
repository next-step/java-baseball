package baseBall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Computer {
	private List<Integer> computerNumbers;
	private int strikeCount = 0;
	private int ballCount = 0;

	public List<Integer> getComputerNumbers() {
		return computerNumbers;
	}

	public void setComputerNumbers(List<Integer> computerNumbers) {
		this.computerNumbers = computerNumbers;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	/*
	* Computer 번호 생성
	* */
	public void generateNumbers() {
		Set<Integer> selectNumbers = new HashSet<>();
		Random random = new Random();

		while (selectNumbers.size() < 3) {
			selectNumbers.add(random.nextInt(9));
		}

		computerNumbers = new ArrayList<>(selectNumbers);
	}

	/*
	* 스트라이크, 볼 확인
	* */
	public void matchResult(List<Integer> userNumbers) {
		countStrike(userNumbers);
		countBall(userNumbers);
	}

	/*
	* 스트라이크 카운트
	* */
	private void countStrike(List<Integer> userNumbers) {
		for (int i = 0; i < userNumbers.size(); i++) {
			strikeCount += matchStrikeNumber(computerNumbers.get(i), userNumbers.get(i));
		}
	}

	/*
	* 볼 카운트
	* */
	private void countBall(List<Integer> userNumbers) {
		for (int i = 0; i < userNumbers.size(); i++) {
			ballCount += matchBallNumber(computerNumbers.get(i), userNumbers.get(i));
		}
	}

	/*
	 * 스트라이크 확인
	 * */
	private int matchStrikeNumber(int comNum, int userNum) {
		if (comNum == userNum) {
			return 1;
		}
		return 0;
	}

	/*
	 * 볼 확인
	 * */
	private int matchBallNumber(int comNum, int userNum) {
		if (comNum == userNum) {
			return 0;
		}
		if (computerNumbers.contains(userNum)) {
			return 1;
		}
		return 0;
	}

	/*
	* 힌트 출력
	* */
	public void showHint() {
		if (strikeCount == 0 && ballCount == 0) {
			System.out.println("낫싱");
			return;
		}
		System.out.println(strikeCount + " 스트라이크 " + ballCount + "볼");
	}
}
