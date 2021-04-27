package baseball.domain;

public interface Umpire {
	GameResult judge(Player pitcher, Player hitter);

	void init();

	boolean isFinished();
}
