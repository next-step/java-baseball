package baseball;

import java.util.ArrayList;

/**
 * 야구 게임 힌트 클래스
 */
public class BaseballGameHint {

    private Strike strike;      // 스트라이크 힌트
    private Ball ball;          // 볼 힌트
    private Nothing nothing;    // 포볼 힌트

    public final int NUMBER_SIZE = 3;   // 숫자 사이즈

    private final ArrayList<Integer> correctNumbers;    // 정답 숫자 리스트
    private final ArrayList<Integer> inputNumbers;      // 입력 숫자 리스트

    private final ArrayList<Integer> strikeIndexArray = new ArrayList<>();  // 스트라이크 인덱스 배열

    /** Getter, Setter **/
    public Strike getStrike() { return strike; }
    public void setStrike(Strike strike) { this.strike = strike; }
    public Ball getBall() { return ball; }
    public void setBall(Ball ball) { this.ball = ball; }
    public Nothing getNothing() { return nothing; }
    public void setNothing(Nothing nothing) { this.nothing = nothing; }

    /**
     * 야구 게임 생성자
     * @param correctNumbers    정답 숫자 리스트
     * @param inputNumbers      입력 숫자 리스트
     */
    BaseballGameHint(ArrayList<Integer> correctNumbers, ArrayList<Integer> inputNumbers) {
        this.correctNumbers = correctNumbers;
        this.inputNumbers = inputNumbers;
        this.strike = new Strike();
        this.ball = new Ball();
        this.nothing = new Nothing();
    }

    /**
     * 야구게임 힌트 생성하기
     */
    public void create() {
        for (int index = 0; index < NUMBER_SIZE; index++) {
            setStrike(index, this.strike);
        }
        for (int index = 0; index < NUMBER_SIZE; index++) {
            setBall(index, this.ball);
        }
        if (this.strike.getCount() == 0 && this.ball.getCount() == 0) {
            this.nothing.add();
        }
        setNothing(this.nothing);
    }

    /**
     * 스트라이크 힌트 구하기
     * @param index 숫자 리스트 인덱스
     * @param strike 스트라이크 힌트
     */
    public void setStrike(int index, Strike strike) {
        int correct = correctNumbers.get(index);
        int input = inputNumbers.get(index);
        if (correct == input) {
            strike.add();
            strikeIndexArray.add(index);
        }
        this.strike = strike;
    }

    /**
     * 볼 힌트 구하기
     * @param index 숫자 리스트 인덱스
     * @param ball 볼 힌트
     */
    public void setBall(int index, Ball ball) {
        if (strikeIndexArray.contains(index)) {
            this.ball = ball;
            return;
        }
        int input = inputNumbers.get(index);
        if (correctNumbers.contains(input)) {
            ball.add();
        }
        this.ball = ball;
    }

    /**
     * 야구게임 힌트 출력하기
     */
    public void print() {
        getStrike().print();
        if (getStrike().getCount() > 0 && getBall().getCount() > 0) {
            System.out.print(" ");
        }
        getBall().print();
        getNothing().print();
        System.out.println();
    }

}