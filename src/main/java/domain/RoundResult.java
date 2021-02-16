package domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    private final List<String> result;
    private final List<BaseballNumber> computer;
    private final List<BaseballNumber> userNumber;
    int strike = 0;
    int ball = 0;

    public RoundResult(List<BaseballNumber> userNumber, List<BaseballNumber> computer) {
        result = new ArrayList<>();
        this.userNumber = userNumber;
        this.computer = computer;
    }

    public List<String> getResult() {
        for (int i=0; i<3;i++) {
            getResultEachNumber(i);
        }
        if (ball > 0) {
            result.add(ball+"볼");
        }
        if (strike > 0) {
            result.add(strike+"스트라이크");
        }
        if (result.size() == 0) {
            result.add("낫싱");
        }
        return result;
    }

    private void getResultEachNumber(int i) {
        if (userNumber.get(i).getNumber() == computer.get(i).getNumber()) {
            strike++;
            return;
        }
        for (int j=0;j<3;j++) {
            if (checkBall(i, j)) break;
        }
    }

    private boolean checkBall(int i, int j) {
        if (userNumber.get(i).getNumber() == computer.get(j).getNumber() && i != j) {
            ball++;
            return true;
        }
        return false;
    }
}
