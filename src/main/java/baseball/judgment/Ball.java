package baseball.judgment;

public class Ball implements JudgmentStrikeOrBall {
    @Override
    public int judge(int charIndex, int currentIndex) {
        return (charIndex > -1 && charIndex != currentIndex) ? 1 : 0;
    }
}
