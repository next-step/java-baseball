package baseball.model;

public class BallCount {

    private short ballCount; // 볼 카운트
    private short strikeCount; // 스트라이크 카운트

    public BallCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    public short getBallCount() {
        return ballCount;
    }

    public short getStrikeCount() {
        return strikeCount;
    }

    public void strike() {
        strikeCount++;
    }

    public void ball() {
        ballCount++;
    }

    public boolean hasStrikeCount() {
        return strikeCount > 0;
    }

    public boolean hasBallCount() {
        return ballCount > 0;
    }

    public boolean isOut(int pitchingCount) {
        return strikeCount == pitchingCount && ballCount == 0;
    }

    public boolean isNothing() {
        return strikeCount == 0 & ballCount == 0;
    }

}
