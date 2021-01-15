import java.util.Scanner;

public class BaseballGame {

    public static void main(String[] args) {
        InternalGame internalGame = new InternalGame();
        RequestUser requestUser = new RequestUser();
        GameInfo realGameInfo = internalGame.getRealGameInfo();
        while (true) {
            GameInfo gameResultInfo = internalGame.startBaseBallGame(realGameInfo);
            String userAnswer = requestUser.askUserForResumeGame(gameResultInfo);
            if (userAnswer == null) {
                continue;
            }
            if (!internalGame.isGameRenew(userAnswer)) {
                break;
            } else {
                realGameInfo = internalGame.getRealGameInfo();
            }
        }
    }
}
