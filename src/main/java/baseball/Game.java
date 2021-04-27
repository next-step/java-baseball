package baseball;

import baseball.player.Computer;
import baseball.player.User;

import java.util.List;

public class Game {

    private static final int BALL_COUNT = 3;

    private static final Computer computer = new Computer();
    private static final User user = new User();
    private static final Score score = new Score();

    public static void main(String[] args) {
        Game game = new Game();
        boolean shutDown = false;

        while (!shutDown) {
            game.start();
            shutDown = game.isReGame();
        }

    }

    public void start(){

        List<Integer> computerBalls = computer.ready(BALL_COUNT);
        boolean isWin = false;
        while (!isWin) {
            System.out.println(Message.START.getMessage());
            score.init();
            int[] userBalls = user.ready(BALL_COUNT);
            isWin = score(computerBalls, userBalls, score);
            System.out.println(score.getFinalScore());
        }
    }

    public boolean isReGame() {
        BaseballUtil BaseballUtil = new BaseballUtil();
        System.out.println(Message.RESTART_OR_EXIT.getMessage());
        String number = BaseballUtil.inputNumber(2);
        if (number.equals("2")) {
            return true;
        }
        return false;
    }

    public boolean score(List<Integer> computerBalls, int[] userBalls, Score score){
        for (int i = 0; i < BALL_COUNT; i++) {
            isStrike(computerBalls.get(i), userBalls[i], score);
            isBall(computerBalls, userBalls[i], score, i);
        }
        return score.judge();
    }


    public void isStrike(int computerBalls, int userBalls, Score score) {
        if (computerBalls == userBalls) {
            score.addStrike();
        }
    }

    public void isBall(List<Integer> computerBalls, int userBalls, Score score, int idx) {
        if (computerBalls.get(idx) == userBalls) {
            return;
        }
        if (computerBalls.contains(userBalls)) {
            score.addBall();
        }

    }
}
