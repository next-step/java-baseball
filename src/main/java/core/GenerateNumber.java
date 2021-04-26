package core;

import java.util.Random;

/**
 * Description : 게임 내 코어 로직 - 정답 생성 관련 class
 *
 * Created by jychoi on 2021/04/26.
 */
public class GenerateNumber {

	private static final int INPUT_SIZE = 3;

	/***
	 * Description: 게임 정답 생성
	 *
	 * @return (int[]) 게임에 사용할 INPUT_SIZE 크기의 정답 후보 배열
	 */
	public int[] generateAnswer() {

		int[] answer = new int[INPUT_SIZE];
		int ceil = 9;

		Random rand = new Random(System.currentTimeMillis());

		for (int idx = 0; idx < INPUT_SIZE; idx++) {
			answer[idx] = rand.nextInt(ceil) + 1;
		}

		return answer;
	}
}
