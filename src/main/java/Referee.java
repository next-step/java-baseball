import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int strike = 0;
    private int balls = 0;

    /**
     * strike count
     * @param thoughtNumber
     * @param presentationNumber
     */
    public void countStrike(int thoughtNumber, int presentationNumber) {
        if (thoughtNumber == presentationNumber) {
            this.strike++;
        }
    }

    /**
     * balls count
     * @param thoughtNumber
     * @param index
     * @param presentationNumber
     */
    public void countBalls(List<Integer> thoughtNumber, int index, int presentationNumber) {
        List<Integer> thoughtNumberCopy = new ArrayList<>(thoughtNumber);
        thoughtNumberCopy.remove(index);

        if (thoughtNumberCopy.contains(presentationNumber)) {
            balls++;
        }
    }

    /**
     * score print
     */
    public void printScore() {
        StringBuilder printString = new StringBuilder();

        if (this.strike == 0 && this.balls == 0) {
            printString.append("낫싱");
        }

        if (this.strike > 0) {
            printString.append(String.format("%d 스트라이크 ", this.strike));
        }

        if (this.balls > 0) {
            printString.append(String.format("%d 볼 ", this.balls));
        }

        System.out.println(printString);
    }

    public int getStrike() {
        return strike;
    }

    public int getBalls() {
        return balls;
    }

    /**
     * initialize strike, balls
     */
    public void initializeCount() {
        this.strike = 0;
        this.balls = 0;
    }
}
