import java.util.HashMap;
import java.util.Scanner;

public class InternalGame {

    private int getStrikeCount(GameInfo realGameInfo, GameInfo userGameInfo) {
        String realNumber = realGameInfo.getNumber();
        String userNumber = userGameInfo.getNumber();
        int strikeCount = 0;
        for (int i = 0; i < realNumber.length(); i++) {
            if (realNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(GameInfo realGameInfo, GameInfo userGameInfo) {
        String realBall = realGameInfo.getNumber();
        String userBall = userGameInfo.getNumber();
        int ballCount = 0;
        for (int i = 0; i < realBall.length(); i++) {
            for (int j = 0; j < userBall.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (realBall.charAt(i) == userBall.charAt(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    //TODO(daeun): 좀 더 나은 방식으로 할 수 없을지 고민
    private GameInfo getGameResultInfo(int strikeCount, int ballCount) {
        GameInfo gameInfo = new GameInfo();
        if (strikeCount == 3) {
            gameInfo.setGameResult(ConstantString.THREE_STRIKE);
            return gameInfo;
        }
        gameInfo.setGameResumption(true);
        if (strikeCount == 0 && ballCount == 0) {
            gameInfo.setGameResult(ConstantString.NOTHING);
        }
        if (ballCount > 0) {
            gameInfo.setGameResult(Integer.toString(ballCount) + ConstantString.BALL);
        }
        if (strikeCount > 0) {
            gameInfo
                .setGameResult(gameInfo.getGameResult() + Integer.toString(strikeCount)
                    + ConstantString.STRIKE);
        }
        gameInfo.setGameResult(gameInfo.getGameResult() + "\n");
        return gameInfo;
    }

    public GameInfo getRealGameInfo() {
        String ball = "";
        HashMap<Integer, Boolean> ballHashMap = new HashMap<>();
        while (ball.length() != 3) {
            double randomValue = Math.random();
            int num = (int) (randomValue * 9) + 1;
            if (ballHashMap.containsKey(num)) {
                continue;
            } else {
                ballHashMap.put(num, true);
                ball += Integer.toString(num);
            }
        }
        GameInfo gameInfo = new GameInfo(ball);
        System.out.println(ball);
        return gameInfo;
    }

    public boolean isSuitableNumber(String number) {
        if (number.length() != 3) {
            return false;
        }
        HashMap<Integer, Boolean> numberHashMap = new HashMap<>();
        for (int i = 0; i < number.length(); i++) {
            if (numberHashMap.containsKey(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public GameInfo startBaseBallGame(GameInfo realGameInfo) {
        RequestUser requestUser = new RequestUser();
        GameInfo userGameInfo = requestUser.askUserForSuitableNum();
        int strikeCount = getStrikeCount(realGameInfo, userGameInfo);
        int ballCount = getBallCount(realGameInfo, userGameInfo);
        GameInfo gameResultInfo = getGameResultInfo(strikeCount, ballCount);
        System.out.println(gameResultInfo.getGameResult());
        return gameResultInfo;
    }
}
