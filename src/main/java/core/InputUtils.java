package core;

/**
 * Description : input 관련 util class
 *
 * Created by jychoi on 2021/04/26.
 */
public class InputUtils {

	/***
	 * Description: input str을 받아서 int[]로 변환하는 method
	 *
	 * @param input input str(from scanner)`
	 * @param inputSize 게임 내 input size (3)
	 * @return (int[]) 입력된 숫자들의 배열
	 * @throws IllegalArgumentException 잘못된 포맷 혹은 잘못된 길이의 input이 올 경우 iae
	 */
	public int[] parseInput(String input, Integer inputSize) throws IllegalArgumentException {

		int[] result = new int[inputSize];

		if (input.trim().length() != inputSize || !input.trim().matches("[1-9].*")) {
			throw new IllegalArgumentException("게임엔 [1-9]숫자 3자리만 입력 가능합니다.");
		}

		for (int idx = 0; idx < input.trim().length(); idx++) {
			result[idx] = Integer.parseInt(String.valueOf(input.charAt(idx)));
		}

		return result;
	}
}
