package baseball.domain;

public interface Umpire {
	<T> T judge(Player pitcher, Player hitter);

	void init();

	boolean isFinished();
}
