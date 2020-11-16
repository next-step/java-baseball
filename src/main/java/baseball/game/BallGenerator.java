package baseball.game;

import java.util.List;

public interface BallGenerator {

	List<Integer> getNumberPool();

	List<Integer> generate(int count);

	int getLimitCount();
}
