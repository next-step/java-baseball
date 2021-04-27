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

    public String checkStart(List<Integer> userBall, List<Integer> computerBall) {
        checkStrike(userBall, computerBall);
        checkBall(userBall, computerBall);
        System.out.println(sb.toString());
        if (this.strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            this.complete = false;
            this.strike = 0;
        }
        return sb.toString();
    }

    public int checkStrike(List<Integer> userBall, List<Integer> computerBall) {
        this.strike = 0;
        for (int i = 0; i < userBall.size(); i++) {
            compareStrike(userBall, computerBall, i);
        }
        result();
        return this.strike;
    }

    private void compareStrike(List<Integer> userBall, List<Integer> computerBall, int count) {
        if (userBall.get(count).equals(computerBall.get(count))) {
            userBall.set(count, 0);
            this.strike++;
        }
    }

    public int checkBall(List<Integer> userBall, List<Integer> computerBall) {
        this.ball = 0;
        for (int i = 0; i < userBall.size(); i++) {
            compareBall(userBall.get(i), computerBall);
        }
        result();
        return this.ball;
    }

    private void compareBall(int userBall, List<Integer> computerBall) {
        if (computerBall.contains(userBall)) {
            this.ball++;
        }
    }

    private void result() {
        sb = new StringBuffer();
        if (this.strike == 0 && this.ball == 0) {
            sb.append("Nothing");
        }
        if (this.strike > 0) {
            sb.append(this.strike + " 스트라이크 ");
        }
        if (this.ball > 0) {
            sb.append(this.ball + " 볼");
        }
    }
}
