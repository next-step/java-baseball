package roles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import constants.JudgeType;
import constants.PlayRules;

public class Refree {

	private String judgement;
	private boolean isOut = false;
	private int strike;
	private int ball;
	private int nothing;

	public String getJudgement() {
		return judgement;
	}

	public boolean isOut() {
		return isOut;
	}

	public void judge(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
		List<String> judgements = new ArrayList<>();
		for (int i = 0; i < hitterNumber.size(); i++) {
			judgements.add(judgeNumber(hitterNumber, pitcherNumber, i));
		}
		setJudgeTypeCount(judgements);
		setJudgement();
		setOut();
	}

	private String judgeNumber(List<Integer> hitterNumber, List<Integer> pitcherNumber, int index) {
		if (isStrike(hitterNumber, pitcherNumber, index)) {
			return JudgeType.STRIKE.name();
		}
		if (isBall(hitterNumber, pitcherNumber, index)) {
			return JudgeType.BALL.name();
		}
		return JudgeType.NOTHING.name();
	}

	private boolean isStrike(List<Integer> hitterNumber, List<Integer> pitcherNumber, int index) {
		return hitterNumber.get(index) == pitcherNumber.get(index);
	}

	private boolean isBall(List<Integer> hitterNumber, List<Integer> pitcherNumber, int index) {
		return !isStrike(hitterNumber, pitcherNumber, index)
			&& hitterNumber.contains(pitcherNumber.get(index));
	}

	private void setJudgeTypeCount(List<String> judgements) {
		this.strike = Collections.frequency(judgements, JudgeType.STRIKE.name());
		this.ball = Collections.frequency(judgements, JudgeType.BALL.name());
		this.nothing = Collections.frequency(judgements, JudgeType.NOTHING.name());
	}

	private void setJudgement() {
		this.judgement = this.nothing == PlayRules.BALL_LENGTH.value() ?
			String.format("%d %s", this.nothing, JudgeType.NOTHING.name()) :
			String.format("%d %s, %d %s", this.strike, JudgeType.STRIKE.name(), this.ball, JudgeType.BALL.name());
	}

	private void setOut() {
		this.isOut = this.strike == PlayRules.BALL_LENGTH.value() ? true : false;
	}
}