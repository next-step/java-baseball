package game.baseball.domain.repository;

import game.baseball.domain.model.AnswerNumber;

public class AnswerNumberRepository {
	private static AnswerNumber answerNumber;

	public void generate() {
		answerNumber = AnswerNumber.generate();
	}

	public AnswerNumber getAnswerNumber(){
		return answerNumber;
	}
}
