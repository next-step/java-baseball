import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
}
