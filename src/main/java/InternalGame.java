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
}
