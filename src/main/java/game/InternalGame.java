package game;

import java.util.HashMap;

public class InternalGame {

    public int getStrikeCount(String realNumber, String userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < realNumber.length(); i++) {
            if (realNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(String realNumber, String userNumber) {
        HashMap<Character, Integer> ballHashMap = new HashMap<>();
        int ballCount = 0;
        for (int i = 0; i < realNumber.length(); i++) {
            ballHashMap.put(realNumber.charAt(i), i);
        }
        for (int i = 0; i < userNumber.length(); i++) {
            if (ballHashMap.containsKey(userNumber.charAt(i)) && i != ballHashMap
                .get(userNumber.charAt(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public GameInfo getGameResultInfo(int strikeCount, int ballCount) {
        GameInfo gameInfo = new GameInfo();
        if (strikeCount == 3) {
            System.out.println(ConstantString.THREE_STRIKE);
            gameInfo.setGameResumption(false);
        } else {
            System.out.println(Unit.printUnit(strikeCount, ballCount));
        }
        return gameInfo;
    }

    public GameInfo getRealRandomNumInfo() {
        String randomNumberStr = "";
        HashMap<Integer, Boolean> ballHashMap = new HashMap<>();
        while (randomNumberStr.length() != 3) {
            int randomNum = (int) (Math.random() * 9) + 1;
            if (!ballHashMap.containsKey(randomNum)) {
                ballHashMap.put(randomNum, true);
                randomNumberStr += Integer.toString(randomNum);
            }
        }
        return new GameInfo(randomNumberStr);
    }

    public GameInfo startBaseBallGame(GameInfo realGameInfo) {
        RequestUser requestUser = new RequestUser();
        GameInfo userGameInfo = requestUser.askUserForSuitableNum();
        int strikeCount = getStrikeCount(realGameInfo.getNumber(), userGameInfo.getNumber());
        int ballCount = getBallCount(realGameInfo.getNumber(), userGameInfo.getNumber());
        GameInfo gameResultInfo = getGameResultInfo(strikeCount, ballCount);
        return gameResultInfo;
    }

    public Boolean isGameRenew(String userAnswer) {
        if (userAnswer.equals("1")) {
            return true;
        }
        return false;
    }
}
