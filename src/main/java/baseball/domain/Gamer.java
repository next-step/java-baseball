package baseball.domain;

public class Gamer implements Answerer {

	private final Questioner questioner;

	private Gamer(Questioner questioner) {
		this.questioner = questioner;
	}

	public static Gamer of(Questioner questioner) {
		return new Gamer(questioner);
	}

	@Override
	public BaseballResult playGame(BaseballNumbers baseballNumbers) {
		return BaseballResult.of(questioner.checkScore(baseballNumbers));
	}
}