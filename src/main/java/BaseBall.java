import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BaseBall {

	Random randomGenerator = new Random();

	public boolean play() {
		List<Integer> answerList = selectNonoverlapThreeNumber();

		System.out.println("숫자를 입력해주세요 : ");
		try {
			//todo 입력에 대한 예외처리해야함.
			int inputNumer = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
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
