package com.woowa.precourse.util;

import com.woowa.precourse.service.ResultType;

public class Answer {
	private int[] answerNumber;

	public Answer(int[] answerNumber) {
		this.answerNumber = answerNumber;
	}

	/* 사용자로부터 입력받은 숫자와 정답을 비교하여 결과 출력 */
	public int[] compareTo(int[] queryNumber) {
		int[] result = { 0, 0 };

		for (int i = 0; i < queryNumber.length; i++) {
			ResultType resultType = getResult(i, queryNumber[i]);

			result[0] += calcResult(resultType, "S");
			result[1] += calcResult(resultType, "B");
		}

		return result;
	}

	/* STRIKE, BALL 수 계산 */
	private int calcResult(ResultType resultType, String StrikeBallFlag) {
		int result = 0;

		if (resultType == ResultType.STRIKE && "S".equals(StrikeBallFlag)) {
			result = 1;
		}
		if (resultType == ResultType.BALL && "B".equals(StrikeBallFlag)) {
			result = 1;
		}
		return result;
	}

	/* 사용자가 입력한 숫자와 정답 중 같은 숫자가 있다면 위치에 따라 STRIKE인지 BALL인지 체크 */
	private ResultType getResult(int numberPosition, int queryNumber) {
		ResultType resultType = ResultType.NOTHING;

		for (int i = 0; i < answerNumber.length; i++) {
			resultType = checkPosition(resultType, answerNumber, queryNumber, i, numberPosition);
		}

		return resultType;
	}

	/* 정답과 사용자가 입력한 숫자가 일치하는지 체크 */
	private ResultType checkPosition(ResultType resultType, int[] answerNumber, int queryNumber, int i,
			int numberPosition) {
		if (answerNumber[i] == queryNumber) {
			resultType = setPosition(i, numberPosition);
		}

		return resultType;
	}

	/* 숫자가 정답과 같은 숫자가 있다면 위치에 따라 Strike인지, Ball인지 체크 */
	private ResultType setPosition(int answerNumberPosition, int queryNumberPosition) {
		ResultType resultType = ResultType.NOTHING;

		if (answerNumberPosition == queryNumberPosition) {
			resultType = ResultType.STRIKE;
		}

		if (answerNumberPosition != queryNumberPosition) {
			resultType = ResultType.BALL;
		}

		return resultType;
	}
}
