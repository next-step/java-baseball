package dev.heowc.referee;

import dev.heowc.ball.Balls;

import java.util.function.Predicate;

enum Judgment {

    STRIKE("strike", "%d 스트라이크", (count) -> count > 0),
    BALL("ball", "%d 볼", (count) -> count > 0),
    MISS("miss", "낫싱", (count) -> count == Balls.SIZE);

    private final String code;
    private final String hint;
    private final Predicate<Integer> predicate;

    Judgment(String code, String hint, Predicate<Integer> predicate) {
        this.code = code;
        this.hint = hint;
        this.predicate = predicate;
    }

    public String hint(int count) {
        if (predicate.test(count)) {
            return String.format(this.hint, count);
        } else {
            return "";
        }
    }
}
