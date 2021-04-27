package io.mwkwon.baseball;

/**
 * 게임 정보 관리를 위한 vo class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class GameControlVO {
    private int strikeCount;            // 스트라이크 갯수
    private int ballCount;              // 볼 갯수

    private int gameFlag;               // 게임 시작, 종료를 컨트롤 하기위한 flag(1: 시작, 2: 종료)
    private String computerNumbers;     // 컴퓨터가 생성한 1에서 9까지 임의의 수 3개로 이루어진 String

    public GameControlVO() {
    }

    public GameControlVO(int gameFlag) {
        this.gameFlag = gameFlag;
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

    public int getGameFlag() {
        return gameFlag;
    }

    public void setGameFlag(int gameFlag) {
        this.gameFlag = gameFlag;
    }

    public String getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(String computerNumbers) {
        this.computerNumbers = computerNumbers;
    }
}
