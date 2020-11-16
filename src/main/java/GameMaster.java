public class GameMaster {

    private boolean wantToPlay;

    private GameRule rule;

    public void readyForPlay() {
        wantToPlay = true;
        rule = new GameRule();
    }

    public boolean isWantToPlay() {
        return wantToPlay;
    }

    public void play() {

    }
}
