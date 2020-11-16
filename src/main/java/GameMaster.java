public class GameMaster {

    private boolean wantToPlay;

    private GameRule gameRule;
    private GamePlayer gamePlayer;

    public void readyForPlay() {
        wantToPlay = true;
        gameRule = new GameRule();
        gamePlayer = new GamePlayer();
    }

    public boolean isWantToPlay() {
        return wantToPlay;
    }

    public void play() {
        String userAnswer = "";
        do {
            System.out.println("숫자를 입력하세요 : ");
            userAnswer = gamePlayer.getAnswer();

        } while(!gameRule.isAnswer(userAnswer));
    }
}
