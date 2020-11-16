package app;

/**
 * 숫자야구 카운트 계산
 */
public class Score {

    private final int STRIKE_MAX_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    /**
     * 스트라이크 카운트 리턴
     *
     * @return int
     */
    public int strikes() {
        return strikeCount;
    }

    /**
     * 볼 카운트 리턴
     *
     * @return int
     */
    public int balls() {
        return ballCount;
    }

    /**
     * 스트라이크 카운트 증가
     */
    public void setStrike() {
        strikeCount++;
    }

    /**
     * 볼 카운트 증가
     */
    public void setBall() {
        ballCount++;
    }

    /**
     * 스트라이크, 볼카운트 클리어
     */
    public void clearCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    /**
     * 게임의 현재 상태 정보 리턴
     *
     * @return boolean
     */
    public boolean getStatus() {
        boolean result = true;
        if (STRIKE_MAX_COUNT == strikeCount) {
            result = false;
        }

        return result;
    }

    /**
     * 사용자 입력에 대한 카운트 결과 메시지 리턴
     *
     * @return String
     */
    public String getResultMessage() {
        String strikes = strikeCount > 0 ? strikeCount + " " + BaseballCount.STRIKE.getValue() : "";
        String balls = ballCount > 0 ? " " + ballCount + " " + BaseballCount.BALL.getValue() : "";

        return (strikeCount == 0 && ballCount == 0) ? BaseballCount.NOTHING.getValue() : strikes + balls;
    }
}
