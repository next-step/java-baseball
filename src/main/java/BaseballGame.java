import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class BaseballGame implements Game {
	private static final int ANSWER_LENGTH = 3;

	private List<Integer> rightAnswer;
	private Scanner scanner;

	public BaseballGame() {
		rightAnswer = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	@Override
	public void play() {
		initQuestion();
		System.out.println(rightAnswer);

		List<Integer> answer;
		while (!isCorrectAnswer(rightAnswer, answer = receiveAnswer())) {
			howManyStrikes(rightAnswer, answer);
			howManyBalls(rightAnswer, answer);
			isNothing(rightAnswer, answer);
			System.out.println();
		}
		System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
	}

	private void initQuestion() {
		while (rightAnswer.size() < ANSWER_LENGTH) {
			addValueIfNotContain(rightAnswer, getRandomNumber());
		}
	}

	private void addValueIfNotContain(List<Integer> list, int randomNumber) {
		if (!list.contains(randomNumber)) {
			list.add(randomNumber);
		}
	}

	private int getRandomNumber() {
		return (int)(Math.random() * 10);
	}

	//---------------------------------------------------------

	private List<Integer> receiveAnswer() {
		System.out.print("숫자를 입력해주세요. : ");
		String input = scanner.nextLine();

		if (areThreeNumbersFromZeroToNine(input)) {
			return stringToIntegers(input);
		}

		System.out.println("0부터 9까지의 숫자 중에 서로 다른 3개의 숫자를 입력해주세요.");
		return receiveAnswer();
	}

	private boolean areThreeNumbersFromZeroToNine(String input) {
		if (!Pattern.matches("[0-9]{3}", input)) {
			return false;
		}

		return duplicateElementRemovedSize(input) == ANSWER_LENGTH;
	}

	private int duplicateElementRemovedSize(String input) {
		Set<String> set = new HashSet<>(Arrays.asList(input.split("")));

		return set.size();
	}

	private List<Integer> stringToIntegers(String input) {
		List<String> strings = Arrays.asList(input.split(""));
		List<Integer> integers = new ArrayList<>();

		for (int i = 0; i < ANSWER_LENGTH; i++) {
			integers.add(Integer.parseInt(strings.get(i)));
		}

		return integers;
	}

	//---------------------------------------------------------

	private boolean isCorrectAnswer(List<Integer> rightAnswer, List<Integer> answer) {
		return rightAnswer.equals(answer);
	}

	private void howManyStrikes(List<Integer> rightAnswer, List<Integer> answer) {
		int cnt = 0;

		for (int i = 0; i < ANSWER_LENGTH; i++) {
			cnt += ifSameValueReturnOne(rightAnswer.get(i), answer.get(i));
		}

		if (cnt != 0) {
			System.out.print(cnt + " 스트라이크 ");
		}
	}

	private int ifSameValueReturnOne(Integer a, Integer b) {
		if (a == b) {
			return 1;
		}

		return 0;
	}

	private void howManyBalls(List<Integer> rightAnswer, List<Integer> answer) {
		int cnt = 0;

		for (int i = 0; i < ANSWER_LENGTH; i++) {
			cnt += containValueAndNotSameIndex(rightAnswer, answer.get(i), i);
		}

		if (cnt != 0) {
			System.out.print(cnt + " 볼 ");
		}
	}

	private int containValueAndNotSameIndex(List<Integer> list, Integer value, int idx) {
		int findIdx = list.indexOf(value);

		if (findIdx == -1 || findIdx == idx) {
			return 0;
		}

		return 1;
	}

	private void isNothing(List<Integer> rightAnswer, List<Integer> answer) {
		boolean flag = false;

		for (Integer value : answer) {
			flag |= rightAnswer.contains(value);
		}

		if (!flag) {
			System.out.print("낫싱 ");
		}
	}
}
