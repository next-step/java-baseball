package baseball.domain;

import baseball.domain.count.Ball;
import baseball.domain.count.Count;
import baseball.domain.count.Strike;

public enum BaseballEnum {
    STRIKE("스트라이크", new Strike()),
    BALL("볼", new Ball());

    private final String message;
    private final Count count;

    BaseballEnum(String message, Count count) {
        this.message = message;
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public int getCount(final Numbers randomNumbers, final Numbers userNumbers) {
        return count.count(randomNumbers, userNumbers);
    }
}
