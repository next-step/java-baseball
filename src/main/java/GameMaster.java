public class GameMaster {

    private final String GAME_PLAY_AGAIN = "1";
    private final String GAME_PLAY_FINISH = "2";

    private boolean wantToPlay = true;

    private GameRule gameRule;
    private GamePlayer gamePlayer;

    public void readyForPlay() {
        gameRule = new GameRule();
        gamePlayer = new GamePlayer();
    }

    public boolean isWantToPlay() {
        return wantToPlay;
    }

    public void play() {
        gameRule.initAnswer();
        do {
            System.out.print("숫자를 입력하세요 : ");
        } while(!gameRule.isAnswer(gamePlayer.getInput()));

        System.out.println("3개의 숫자를 모두 맞히셨습니다!. 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면2를 입력하세요.");
        setWantToPlay(gamePlayer.getInput());
    }

    private void setWantToPlay(String input) {
        if(input.equals(GAME_PLAY_AGAIN)) {
            wantToPlay = true;
            return;
        }

        if(input.equals(GAME_PLAY_FINISH)) {
            wantToPlay = false;
            return;
        }
    }
}
