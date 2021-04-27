package baseball.domain;

import java.util.Map;

public interface GameResult {
	Map<BallKind, Integer> getResultMap();
	String getMessage();
}
