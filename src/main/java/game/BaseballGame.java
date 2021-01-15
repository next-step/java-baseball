package game;

public class BaseballGame {

    public static void main(String[] args) {
        InternalGame internalGame = new InternalGame();
        RequestUser requestUser = new RequestUser();
        GameInfo realGameInfo = internalGame.getRealRandomNumInfo();
        while (true) {
            GameInfo gameResultInfo = internalGame.startBaseBallGame(realGameInfo);
            if (gameResultInfo.isGameResumption()) {
                continue;
            }
            Boolean resumeGame = requestUser.askUserForRenewGame();
            if (!resumeGame) {
                break;
            }
            realGameInfo = internalGame.getRealRandomNumInfo();
        }
    }
}
