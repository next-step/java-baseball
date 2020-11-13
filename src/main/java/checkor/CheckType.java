package checkor;

public enum CheckType {

    NOTHING("낫싱"),
    STRIKE("스트라이크 "),
    BALL("볼 ");

    private String print;

    CheckType(String print) {
        this.print = print;
    }

    public static String printCheckType(int strike, int ball) {
        StringBuilder builder = new StringBuilder();
        if (strike == 0 && ball == 0) builder.append(NOTHING.print);
        if (strike > 0) builder.append(strike).append(STRIKE.print);
        if (ball > 0) builder.append(ball).append(BALL.print);
        return builder.toString();
    }
}
