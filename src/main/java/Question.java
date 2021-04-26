import java.util.ArrayList;
import java.util.List;

public class Question {
	private List<Integer> question;

	public void setUserQuestion(int first, int second, int last) {
		List<Integer> userQuestion = new ArrayList<Integer>();
		userQuestion.add(first);
		userQuestion.add(second);
		userQuestion.add(last);
		this.question = userQuestion;
	}

	public List<Integer> getUserQuestion() {
		return this.question;
	}

	public void init() {
		this.question = new ArrayList<Integer>();
	}
}
