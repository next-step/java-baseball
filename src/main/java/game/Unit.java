package game;

public enum Unit {
    NOTHING("낫싱"),
    STRIKE("스트라이크 "),
    BALL("볼 ");

    private String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public static String printUnit(int strikeCount, int ballCount) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strikeCount == 0 && ballCount == 0) {
            stringBuilder.append(NOTHING.unit);
        }
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append(BALL.unit);
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append(STRIKE.unit);
        }
        return stringBuilder.toString();
    }
}
