package playball.io;

import playball.exception.PlayBallIllegalArgumentException;

import static playball.exception.ExceptionMessage.INVALID_PLAY_BALL_GAME_STATUS_MESSAGE;

public enum GamePlayStatus {

    START(0),
    RE_START(1),
    END(2);

    private final Integer status;

    GamePlayStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public static GamePlayStatus findGamePlayStatus(int input) {
        GamePlayStatus result = null;
        for (GamePlayStatus gamePlayStatus : GamePlayStatus.values()) {
            result = findGamePlayStatus(gamePlayStatus, input);
        }

        if (result == null) {
            throw new PlayBallIllegalArgumentException(INVALID_PLAY_BALL_GAME_STATUS_MESSAGE);
        }

        return result;
    }

    private static GamePlayStatus findGamePlayStatus(GamePlayStatus gamePlayStatus, int input) {
        if (gamePlayStatus.getStatus() == input) {
            return gamePlayStatus;
        }

        return null;
    }
}
