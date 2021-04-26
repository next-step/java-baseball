package com.precourse.baseball;

import java.util.List;

public class Playground {
	private final NumberGenerator numberGenerator = new NumberGenerator();
	private final UserScanner userScanner = new UserScanner();

	public void play() {
		List<Integer> comNumList = numberGenerator.generate();
		List<Integer> userNumList;
		do {
			userNumList = getNumberList();
		} while (!isOut(comNumList, userNumList));
	}

	/**
	 * 사용자가 입력한 수를 반환
	 * @return 사용자 입력 수 List
	 */
	public List<Integer> getNumberList() {
		System.out.print(Constants.INPUT_MESSAGE);
		return userScanner.scanNumber();
	}

	/**
	 * 게임이 종료되는지 확인
	 * @param com : 상대방 숫자 3개
	 * @param user : 사용자 숫자 3개
	 * @return 스트라이크의 값 3이면 true
	 */
	public boolean isOut(List<Integer> com, List<Integer> user) {
		Hint hint = new Hint(com, user);
		System.out.println(hint.getHint());
		return hint.strike == Constants.STRIKE_OUT;
	}

}
