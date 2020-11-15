import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	private LinkedHashSet<Integer> question;
	private LinkedHashSet<Integer> answer;
	private BaseballScore score;

	public LinkedHashSet<Integer> getQuestion() {
		return question;
	}

	public LinkedHashSet<Integer> getAnswer() {
		return answer;
	}

	BaseballGame() {
		question = new LinkedHashSet<>(3);
		answer = new LinkedHashSet<>(3);
		score = new BaseballScore();
	}

	private void createGame() {
		createQuestion();
	}

	public void startGame() {
		createGame();

		do {
			inputAnswers();
			decideAnswers();
		} while (!decideAnswers());
	}

	public boolean decideAnswers() {
		score.initialStrikeAndBall();
		doCheckStrikeAndBall();
		if (score.getStrike() == 3) {
			return true;
		}
		return false;
	}

	private void doCheckStrikeAndBall() {
		int index_i = 0;
		for (Iterator<Integer> q = question.iterator(); q.hasNext();) {
			int question = q.next();
			decideStrikeAndBall(question, index_i++);
		}
	}

	private void decideStrikeAndBall(int question, int index_i) {
		int index_j = 0;
		for (Iterator<Integer> a = answer.iterator(); a.hasNext();) {
			int answer = a.next();
			_decideStrikeAndBall(question, answer, index_i, index_j++);
		}
	}

	private void _decideStrikeAndBall(int question, int answer, int index_i, int index_j) {
		if (question == answer) {
			addStrikeOrBall(index_i, index_j);
		}
	}

	private void addStrikeOrBall(int i, int j) {
		if (i == j) {
			score.addStrike();
			return;
		}
		score.addBall();
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
