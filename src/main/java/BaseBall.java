import java.io.IOException;
import java.util.*;

public class BaseBall {

	Random randomGenerator = new Random();

	Scanner sc = new Scanner(System.in);

	public boolean play() {
		List<Integer> answerList = selectNonoverlapThreeNumber();
		printMessage("숫자를 입력해주세요 : ");
		//todo 입력에 대한 예외처리해야함.
		List<Integer> inputNumberList = readNonoverThreeNumber();
//		System.out.println(inputNumberList);
		return true;
	}

	private void collectDigits(int input, List<Integer> digits) {
		if (input / 10 > 0) {
			collectDigits(input / 10, digits);
		}
		digits.add(input % 10);
	}

	private List<Integer> readNonoverThreeNumber() {
		List<Integer> inputList = new ArrayList<Integer>();
		Integer input = sc.nextInt();
		collectDigits(input, inputList);
		return inputList;
	}

	private void printMessage(String message) {
		System.out.println(message);
	}

	private List<Integer> selectNonoverlapThreeNumber() {
		List<Integer> answerList = new ArrayList<>();
		HashSet<Integer> answerSet = new HashSet<>();
		do {
			int randomNum = randomGenerator.nextInt(9) + 1;
			answerList = addNonoverNumer(randomNum, answerSet, answerList);
		} while (answerSet.size() < 3);

		return answerList;
	}

	private List<Integer> addNonoverNumer(int randomNum, HashSet<Integer> answerSet, List<Integer> answerList) {
		if (answerSet.add(randomNum)) {
			answerList.add(randomNum);
		}
		return answerList;
	}
}
