package com.baseballgame.domain;

import java.util.Objects;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import com.baseballgame.common.InputUtil;
import com.baseballgame.common.UserRequest;

/**
 * 유저 타입
 */
public class User {

	/**
	 * 사용자 추측 답 제출
	 * @return
	 */
	public String submitAnswer() {
		return inputAnswer();
	}

	/**
	 * 사용자 요청 제출
	 * @return
	 */
	public String submitUserRequest(){
		String userRequest = InputUtil.inputWithScanner();

		if(isValidateUserRequestInput(userRequest)){
			return userRequest;
		}
		return submitUserRequest();
	}

	/**
	 * 사용자 요청 입력값 유효성 체크
	 * @param userRequest
	 * @return
	 */
	private boolean isValidateUserRequestInput(String userRequest) {
		if(userRequest.length() == 1 && !Objects.isNull(UserRequest.resolve(userRequest))) {
			return true;
		}
		System.out.println("입력값이 잘 못 되었습니다. 1 또는 2를 입력해주세요.");
		return false;
	}

	/**
	 * 사용자 추측 답 입력
	 * @return
	 */
	private String inputAnswer() {
		String answer = InputUtil.inputWithScanner();
		if (isValidateAnswerInput(answer)) {
			return answer;
		}
		return inputAnswer();
	}

	/**
	 * 사용자 추측 답 입력값 유효성 체크
	 * @param answer
	 * @return
	 */
	private boolean isValidateAnswerInput(String answer) {
		if(answer.length() == 3 && StringUtils.isNumeric(answer)) {
			return true;
		}
		System.out.println("입력값이 잘 못 되었습니다. 세자리 숫자만 다시 입력해주세요.");
		return false;
	}

}
