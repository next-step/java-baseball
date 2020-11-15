package baseball.domain;

import java.util.List;

public interface Questioner {
	int numberSize();

	List<BaseballStatus> checkScore(BaseballNumbers baseballNumbers);
}
