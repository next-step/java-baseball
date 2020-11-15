import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NumberBaseBall {
	private static final List<String> NUMBERS =
		Collections.unmodifiableList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

	private static final int NUMBERS_MAX_INDEX = 8;
	private static final int MAX_DIGIT = 3;

	public String makeRandomNumberString() {
		List<String> tempNumbers = new ArrayList(NUMBERS);
		Random random = new Random();
		String answer = "";
		for (int i = 0; i < MAX_DIGIT; i++) {
			int randomIdx = random.nextInt(NUMBERS_MAX_INDEX - i);
			answer += tempNumbers.get(randomIdx);
			tempNumbers.remove(randomIdx);
		}
		return answer;
	}

	public String calculate(String answerNumber, String inputNumber) {
		List<String> answerNumbers = Arrays.asList(answerNumber.split(""));
		List<String> inputNumbers = Arrays.asList(inputNumber.split(""));
		int strikeCnt = 0;
		int ballAndStrikeCnt = 0;

		for (int i = 0; i < MAX_DIGIT; i++) {
			strikeCnt += getStrikeCnt(answerNumbers.get(i), inputNumbers.get(i));
			ballAndStrikeCnt += getBallAndStrikeCnt(answerNumbers, inputNumbers.get(i));
		}
		return makeResult(strikeCnt, ballAndStrikeCnt - strikeCnt);
	}

	private int getBallAndStrikeCnt(List<String> answerNumbers, String inputNumber) {
		Set<String> answerNumberSet = new HashSet<>(answerNumbers);
		if (answerNumberSet.contains(inputNumber)) {
			return 1;
		}
		return 0;
	}

	private int getStrikeCnt(String answerNumber, String inputNumber) {
		if (answerNumber.equals(inputNumber)) {
			return 1;
		}
		return 0;
	}

	private String makeResult(int strikeCnt, int ballCnt) {
		StringBuilder sb = new StringBuilder();
		String space = " ";

		if (strikeCnt > 0) {
			sb.append(strikeCnt).append("스트라이크").append(space);
		}
		if (ballCnt > 0) {
			sb.append(ballCnt).append("볼");
		}
		return sb.toString();
	}
}
