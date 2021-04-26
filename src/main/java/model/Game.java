package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	private static final int MIN = 1;
	private static final int MAX = 9;

	private int[] com = {};
	private int[] user = {};

	private int strike = 0;
	private int ball = 0;

	public Game() {
		this.generateProblems();
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void setCom(int[] com) {
		this.com = com;
	}

	public void setUser(int[] user) {
		this.user = user;
	}

	/**
	 * 스트라이크와, 볼의 개수를 초기화합니다.
	 */
	public void clearStrikeAndBall() {
		this.strike = 0;
		this.ball = 0;
	}

	/**
	 * 정답을 맞추면 새로운 게임을 실행할지, 종료할지를 결정한다.
	 * @return 게임 실행 여부
	 * @throws IOException
	 */
	public boolean checkStrikeAndBall() throws IOException {
		if (this.strike == 3) {
			this.clearStrikeAndBall();
			this.printGameClear();
			this.printReplayOrExit();
			return inputReplayOrExit();
		}
		this.clearStrikeAndBall();
		return true;
	}

	/**
	 * 유저의 입력에 따라 게임을 계속할지 종료할지 결정한다.
	 * @return
	 * @throws IOException
	 */
	private boolean inputReplayOrExit() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if(br.readLine().equals("1")) {
			this.generateProblems();
			return true;
		}
		return false;
	}

	/**
	 * 정답을 맞췄다는 문자열을 콘솔에 출력합니다.
	 */
	private void printGameClear() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	/**
	 * 게임을 재시작할지, 종료할지 여부를 묻는 문자열을 콘솔에 출력한다.
	 */
	private void printReplayOrExit() {
		System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	/**
	 * 컴퓨터가 랜덤으로 문제를 생성하여 저장한다.
	 */
	private void generateProblems() {
		LinkedHashSet<Integer> problems = new LinkedHashSet<>();

		while(isCreatedAllNumbers(problems)) {
			int num;
			num = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
			problems.add(num);
		}

		this.setCom(problems.stream().mapToInt(Integer::intValue).toArray());
	}

	/**
	 * 모든 문제를 생성하였는지의 여부를 반환한다.
	 * @param problems
	 * @return 모든 문제 생성 여부
	 */
	private boolean isCreatedAllNumbers(LinkedHashSet problems) {
		if (problems.size() == 3) {
			return false;
		}
		return true;
	}

	/**
	 * 스트라이크와, 볼의 개수를 계산한다.
	 */
	public void computeStrikeAndBall() {
		selectValueToCompare();
	}

	/**
	 * 인덱스 하나를 골라, 비교할 숫자들을 고른다.
	 */
	private void selectValueToCompare() {
		for (int i = 0; i < 3; i++) {
			selectOtherValueToCompare(i);
		}
	}

	/**
	 * 나머지 인덱스를 골라서, 값을 비교한다.
	 * @param i
	 */
	private void selectOtherValueToCompare(int i) {
		for (int j = 0; j < 3; j++) {
			compareValue(i, j);
		}
	}

	/**
	 * 값이 같은지를 비교한 후에, 스트라이크인지 볼인지를 결정한다.
	 * @param i 먼저 선택된 인덱스
	 * @param j 나중에 선택된 인덱스
	 */
	private void compareValue(int i, int j) {
		if (isStrikeOrBall(i, j, i == j)) {
			strike++;
			return;
		}
		if (isStrikeOrBall(i, j, i != j)) {
			ball++;
			return;
		}
	}

	/**
	 *
	 * @param i 먼저 선택된 인덱스
	 * @param j 나중에 선택된 인덱스
	 * @param b 평가 식
	 * @return
	 */
	private boolean isStrikeOrBall(int i, int j, boolean b) {
		return com[i] == user[j] && b;
	}
}
