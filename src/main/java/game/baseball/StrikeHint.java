package game.baseball;

public class StrikeHint extends NumberHint {

    public static final String STRIKE_MARKING = "스트라이크";

    public StrikeHint(int count) {
        super(count, STRIKE_MARKING);
    }
}
