import java.util.LinkedHashSet;
import java.util.Random;

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

}
