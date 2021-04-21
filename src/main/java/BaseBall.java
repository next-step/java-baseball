public class BaseBall {

    public static final String FOUR_BALL = "4B";

    private String answer;

    public BaseBall(String answer) {
        this.answer = answer;
    }

    public String play(String input) {
        if (notContainsByAnswer(input)) {
            return FOUR_BALL;
        }

        return "";
    }

    private boolean notContainsByAnswer(String playerInput) {
        return !answer.contains(playerInput);
    }
}
