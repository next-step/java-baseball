public class InternalGame {

    private int getStrikeCount(GameInfo realGameInfo, GameInfo userGameInfo) {
        String realBall = realGameInfo.getBall();
        String userBall = userGameInfo.getBall();
        int strikeCount = 0;
        for (int i = 0; i < realBall.length(); i++) {
            if (realBall.charAt(i) == userBall.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
