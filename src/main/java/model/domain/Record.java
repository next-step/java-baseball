package model.domain;

import lombok.Getter;

@Getter
public class Record {
    private static final int WIN_COUNT = 3;
    private static final int ZERO = 0;

    private int strikeCount;
    private int ballCount;

    private Record(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isWin() {
        return this.strikeCount == WIN_COUNT;
    }

    public boolean isNotThing() {
        return this.strikeCount == ZERO && this.ballCount == ZERO;
    }

    public static Record createWin() {
        return new Record(WIN_COUNT, ZERO);
    }

    public static Record of(int strikeCount, int ballCount) {
        return new Record(strikeCount, ballCount);
    }
}
