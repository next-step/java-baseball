public class BaseballGame {

    public static void main(String[] args) {
        InternalGame internalGame = new InternalGame();
        RequestUser requestUser = new RequestUser();
        GameInfo realGameInfo = internalGame.getRealGameInfo();
        while (true) {
            GameInfo gameResultInfo = internalGame.startBaseBallGame(realGameInfo);
            if (gameResultInfo.isGameResumption()) {
                continue;
            }
            Boolean resumeGame = requestUser.askUserForRenewGame();
            if (!resumeGame) {
                break;
            }
            realGameInfo = internalGame.getRealGameInfo();
        }
    }
}
