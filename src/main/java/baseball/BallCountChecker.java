package baseball;

public class BallCountChecker {
    public static String check(final String input, final String answer) {
        BallCount ballCount = new BallCount();

        for(int i = 0; i < BallCount.BALL_COUNT_SIZE; i++) {
            if(isStrike(input.charAt(i), answer.charAt(i))){
                ballCount.addStrike();
            } else if(isBall(input.charAt(i), answer)){
                ballCount.addBall();
            }
        }

        return ballCount.toString();
    }

    private static boolean isStrike(final char input, final char answer) {
        if(input == answer){
            return  true;
        }
        return false;
    }

    private static boolean isBall(final char input, final String answer) {
        if(answer.contains(Character.toString(input))){
            return true;
        }
        return false;
    }
}
