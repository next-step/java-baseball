import java.util.List;

public class Question {
	private List<Integer> question;

	public void setUserQuestion(List<Integer> userQuestion) {
		this.question = userQuestion;
	}

	public List<Integer> getUserQuestion() {
		return this.question;
	}
}
