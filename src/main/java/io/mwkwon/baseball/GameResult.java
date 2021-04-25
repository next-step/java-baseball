package io.mwkwon.baseball;

/**
 * 게임 결과 저장 class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class GameResult {
    private int strikeCount;    // 스트라이크 갯수
    private int ballCount;      // 볼 갯수

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
