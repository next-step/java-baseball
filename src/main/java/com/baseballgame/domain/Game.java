package com.baseballgame.domain;

import com.baseballgame.common.UserRequest;

public class Game {
	private final Computer computer;
	private final User user;

	public Game(Computer computer, User user) {
		this.computer = computer;
		this.user = user;
	}

	/**
	 * 게임 시작
	 */
	public void start() {
		System.out.println("------------- 베이스볼 게임을 시작합니다. -------------");
		proceed();
	}

	/**
	 * 게임 진행중
	 */
	private void proceed() {
		String userAnswer;
		computer.makeBaseballNumber();

		do {
			System.out.printf("숫자를 입력해주세요 : ");
			userAnswer = user.submitAnswer();
		} while (!computer.isAllMatches(userAnswer));

		if (!UserRequest.END.matches(user.submitUserRequest())) {
			proceed();
		}
		end();
	}

	/**
	 * 게임 종료
	 */
	private void end() {
		System.out.println("------------- 베이스볼 게임을 종료합니다. -------------");
	}

}
