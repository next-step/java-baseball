package baseball.model;

import java.util.List;

import baseball.utils.RandomUtil;

public class Baseball {
	public static final int ANSWER_SIZE = 3;

	private List<Integer> answer;

	public void init() {
		answer = RandomUtil.createNonDuplicatedNumberList(ANSWER_SIZE);
	}

	public List<Integer> getAnswer() {
		return answer;
	}
}
