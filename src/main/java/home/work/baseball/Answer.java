package home.work.baseball;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Answer {
	
	private int strike;
	private int ball;
	
	public void increaseStrike() {
		this.strike++;
	}
	
	public void increaseBall() {
		this.ball++;
	}

	public String print() {
		if (strike + ball == 0) return "낫싱";
		
		List<String> answerList = new ArrayList<>();
		if (strike > 0) answerList.add(strike + " 스트라이크");
		if (ball > 0) answerList.add(ball + "볼");
		return String.join(" ", answerList);
	}
}
