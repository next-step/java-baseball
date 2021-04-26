import java.util.List;

public class CompareBall {

    private int strike;
    private int ball;
    private boolean complete;
    private StringBuffer sb;

    public void setStatus(boolean status) {
        this.complete = status;
    }

    public boolean getStatus() {
        return this.complete;
    }

    public void checkStart(List<Integer> userBall, List<Integer> computerBall) {
        sb = new StringBuffer();
        checkStrike(userBall, computerBall);
        checkBall(userBall, computerBall);
        result(userBall);
        if (strike == 3) {
            complete = false;
            strike = 0;
        }
    }

    private int checkStrike(List<Integer> userBall, List<Integer> computerBall) {
        strike = 0;
        for (int i = 0; i < userBall.size(); i++) {
            compareStrike(userBall, computerBall, i);
        }
        if (strike > 0) {
            sb.append(strike + " 스트라이크 ");
        }
        return strike;
    }

    private void compareStrike(List<Integer> userBall, List<Integer> computerBall, int count) {
        if (userBall.get(count).equals(computerBall.get(count))) {
            userBall.set(count, 0);
            strike++;
        }
    }

    private int checkBall(List<Integer> userBall, List<Integer> computerBall) {
        ball = 0;
        for (int i = 0; i < userBall.size(); i++) {
            compareBall(userBall.get(i), computerBall);
        }
        if (ball > 0) {
            sb.append(ball + " 볼");
        }
        return ball;
    }

    private void compareBall(int userBall, List<Integer> computerBall) {
        if (computerBall.contains(userBall)) {
            ball++;
        }
    }

    private void result(List<Integer> userBall) {
        if (strike == 0 && ball == 0) {
            sb.append("Nothing");
        }
        System.out.println(sb.toString());
    }
}
