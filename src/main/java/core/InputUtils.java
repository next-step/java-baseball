package core;

import java.util.Set;
import java.util.TreeSet;

/**
 * Description : input 관련 util class
 *
 * Created by jychoi on 2021/04/26.
 */
public class InputUtils {

	/***
	 * Description: input이 1이면 새로 시작, 2면 종료
	 * @param input user input
	 * @return (T / F)
	 */
	public boolean isGameRestart(Integer input) {

		boolean result = false;

		if (input.equals(1)) {
			result = true;
		}

		return result;
	}

	/***
	 * Description: input str을 받아서 int[]로 변환하는 method
	 *
	 * @param input input str(from scanner)`
	 * @param inputSize 게임 내 input size (3)
	 * @return (int[]) 입력된 숫자들의 배열
	 * @throws IllegalArgumentException 잘못된 포맷 혹은 잘못된 길이의 input이 올 경우 iae
	 */
	public Integer[] parseInput(String input, Integer inputSize) throws IllegalArgumentException {

		Set<Integer> resultSet = new TreeSet<>();
		Integer[] result = new Integer[inputSize];

		for (int idx = 0; idx < input.trim().length(); idx++) {
			resultSet.add(Integer.parseInt(String.valueOf(input.charAt(idx))));
		}

		if (input.trim().length() != inputSize || !input.trim().matches("[1-9].*") || resultSet.size() != inputSize) {
			throw new IllegalArgumentException("게임엔 서로 다른 숫자[1-9] 3자리만 입력 가능합니다.");
		}

		return resultSet.toArray(result);
	}
}
