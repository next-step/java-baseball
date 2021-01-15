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
}
