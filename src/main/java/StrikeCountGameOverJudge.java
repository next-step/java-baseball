import number.HintsCount;
import number.Numbers;

public class StrikeCountGameOverJudge implements GameOverJudge {

	@Override
	public boolean isGameOver(HintsCount hintsCount) {
		int strikeCount = hintsCount.countOfStrike();
		return strikeCount == Numbers.LENGTH;
	}

}
