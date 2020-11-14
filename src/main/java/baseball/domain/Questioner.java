package baseball.domain;

import baseball.util.NumberGenerator;

public interface Questioner {
	void generateNumbers(NumberGenerator generator);

	int numberSize();
}
