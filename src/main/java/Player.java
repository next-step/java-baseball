import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final String INPUT_MSG = "숫자를 입력해주세요 : ";

    private ArrayList<Integer> numberList;
    private int strikeCount = 0;
    private int ballCount = 0;

    Scanner sc = new Scanner(System.in);

    public Player() {}

    public int requestInput(boolean isPlaying) {
    }

    public void initBallCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public ArrayList<Integer> getNumberList() {
        return numberList;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }
}
