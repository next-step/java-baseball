import java.util.ArrayList;
import java.util.List;

public class Question {
	private List<Integer> question;

	public void setUserQuestion(List<Integer> userQuestion) {
		//검증 필요
		this.question = userQuestion;
	}

	public List<Integer> getUserQuestion() {
		return this.question;
	}

	public void init() {
		this.question = new ArrayList<Integer>();
	}
}
