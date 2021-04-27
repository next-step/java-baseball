import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseBallNumberGenerator {

	private int numberLimit;

	public BaseBallNumberGenerator(int numberLimit) {
		this.numberLimit = numberLimit;
	}

	/**
	 * 컴퓨터가 사용할 난수 생성
	 * @param randomLimit - n값 이하의 난수 파라미터
	 * @return
	 */
	public String makeComputerNumbers(int randomLimit, StringBuffer numberBuffer) {

		Random random = new Random();
		if (numberBuffer == null) {
			numberBuffer = new StringBuffer();
		}

		if (numberBuffer.length() >= numberLimit) {
			return numberBuffer.toString();
		}

		int randInt = random.nextInt(randomLimit);
		if (randInt > 0 && numberBuffer.indexOf(String.valueOf(randInt)) == -1) {
			numberBuffer.append(String.valueOf(randInt));
		}
		numberBuffer = new StringBuffer(makeComputerNumbers(randomLimit, numberBuffer));

		return numberBuffer.toString();
	}

	/**
	 * 입력 받은 숫자들을 중복을 제거하여 리스트로 변환
	 * @param inputStr
	 * @return
	 */
	public List<String> makeNumberList(String inputStr) {
		String[] inputArray = inputStr.split("");
		Set<String> inputSet = new LinkedHashSet<>();
		for (String compareInput : inputArray) {
			inputSet.add(compareInput);
		}
		List<String> inputList = new ArrayList<>(inputSet);
		return inputList;
	}

	/**
	 * 변환된 List 대하여 길이 검사
	 * @param inputList
	 * @return
	 */
	public boolean checkListSize(List<String> inputList) {
		if (inputList.size() == numberLimit) {
			return true;
		}
		return false;
	}

}
