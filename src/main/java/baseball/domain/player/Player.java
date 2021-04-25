package baseball.domain.player;

public class Player {

    private PlayStatus playStatus;

    public Player(PlayStatus playStatus) {
        this.playStatus = playStatus;
    }

    public boolean isPlaying() {
        return playStatus.isPlaying();
    }

    public void setPlayStatus(PlayStatus playStatus) {
        this.playStatus = playStatus;
    }
}
