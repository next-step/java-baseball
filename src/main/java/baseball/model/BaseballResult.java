package baseball.model;

public class BaseballResult {
    private final int strike;
    private final int ball;
    private final int numbersSize; // 야구 게임에 설정해 놓은 숫자 길이.

    public BaseballResult() {
        this.strike = 0;
        this.ball = 0;
        this.numbersSize = 0;
    }

    public BaseballResult(int strike, int ball, int numbersSize) {
        this.strike = strike;
        this.ball = ball;
        this.numbersSize = numbersSize;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }
    
    /**
     * 게임 종료 여부 조회.
     * @return 게임 종료 여부.
     */
    public boolean isFinish() {
        return this.strike > 0 && this.strike == this.numbersSize;
    }

    /**
     * 결과 메시지 조회.
     * @return 결과 메시지.
     */
    public String getResultMessage() {
        StringBuilder messageBuilder = new StringBuilder();

        if (this.strike > 0) {
            messageBuilder.append(String.valueOf(this.strike)).append("스트라이크");
        }

        if (this.strike > 0 && this.ball > 0) {
            messageBuilder.append(" ");
        }

        if (this.ball > 0) {
            messageBuilder.append(String.valueOf(this.ball)).append("볼");
        }

        return messageBuilder.toString();
    }
 }
