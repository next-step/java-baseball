import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	private LinkedHashSet<Integer> question;
	private LinkedHashSet<Integer> answer;

	public LinkedHashSet<Integer> getQuestion() {
		return question;
	}

	public LinkedHashSet<Integer> getAnswer() {
		return answer;
	}

	BaseballGame() {
		question = new LinkedHashSet<>(3);
		answer = new LinkedHashSet<>(3);
	}

	public void createGame() {
		createQuestion();
	}

	private void createQuestion() {
		Random random = new Random();

		while(question.size() != 3) {
			question.add(random.nextInt(9) + 1);
		}
	}

	private void inputAnswers() {
		System.out.println("숫자를 입력해주세요 : ");

		Scanner scanner = new Scanner(System.in);
		String numbers = scanner.nextLine();

		String[] handoutAnswers = numbers.split("");

		addAnswers(handoutAnswers);
	}

	public void addAnswers(String[] numbers) {
		answer.clear();
		for (int i = 0; i < 3; i++) {
			answer.add(Integer.parseInt(numbers[i]));
		}
	}

}
