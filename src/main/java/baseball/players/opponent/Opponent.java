package baseball.players.opponent;

import java.util.List;

public interface Opponent {
	List<Integer> getHiddenNumbers();

	void reset();
}
