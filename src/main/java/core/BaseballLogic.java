package core;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Description : 게임 내 코어 로직 (정답 생성, 게임 진행(정답 맞추기 관련) class
 *
 * Created by jychoi on 2021/04/26.
 */
public class BaseballLogic {

	/**
	 * Description: 게임 정답 생성
	 *
	 * @param inputSize 게임에 사용할 INPUT_SIZE 크기
	 * @return (int[]) 게임에 사용할 INPUT_SIZE 크기의 정답 후보 배열
	 */
	public Integer[] generateAnswer(int inputSize) {

		Set<Integer> answerSet = new TreeSet<>();
		Integer[] answer = new Integer[inputSize];
		int ceil = 9;

		Random rand = new Random(System.currentTimeMillis());

		while (answerSet.size() != inputSize) {
			answerSet.add(rand.nextInt(ceil) + 1);
		}

		return answerSet.toArray(answer);
	}

	/**
	 * Description: 현재 문제(입력 단위) 진행 method
	 *
	 * @param answer 정답 배열
	 * @param userInput 사용자 입력 배열
	 * @return AnswerObject
	 */
	public AnswerObject run(Integer[] answer, Integer[] userInput) {

		AnswerObject answerObject = new AnswerObject(0, 0);

		for (int idx = 0; idx < answer.length; idx++) {
			checkStrikeOrBall(idx, answer, userInput[idx], answerObject);
		}

		return answerObject;
	}

	/**
	 * Description : run()에서 사용하는 private method, user input의 한 문자(숫자)를 대상으로 정답 배열과 비교하여,
	 * 				 strike / ball을 판독하는 method
	 *
	 * @param currentIdx 현재 idx(user input의)
	 * @param answer 정답 배열
	 * @param userInput user input 배열
	 * @param answerObject 현재 진행 중인 문제의 answer object class
	 * @return AnswerObject
	 */
	public AnswerObject checkStrikeOrBall(int currentIdx, Integer[] answer, Integer userInput,
		AnswerObject answerObject) {

		// 완전 일치 -> 스트라이크
		if (userInput.equals(answer[currentIdx])) {
			answerObject.setStrike(answerObject.getStrike() + 1);
			return answerObject;
		}

		// 정답 배열과 현재 원소가
		if (Arrays.asList(answer).contains(userInput)) {
			answerObject.setBall(answerObject.getBall() + 1);
		}

		return answerObject;
	}
}
