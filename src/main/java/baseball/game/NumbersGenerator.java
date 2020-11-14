package baseball.game;

import java.util.List;

public interface NumbersGenerator {

	List<Integer> getAllowedNumbers();
	List<Integer> generate(int count);
	int getLimitCount();
}
