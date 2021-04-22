public class Rule {
    private static final int DIGIT = 3;

    public static boolean isValid(int[] numList) {
        if (numList == null) return false;
        if (numList.length != 3) return false;
        return ((numList[0] != numList[1]) && (numList[1] != numList[2]) && (numList[2] != numList[0]));
    }

    public static Judje judge(int[] dealerList, int[] playerList) {
        if (!isValid(dealerList)) return null;
        if (!isValid(playerList)) return null;

        Judje judje = new Judje();

        if (dealerList[0] == playerList[0]) judje.strike++;
        if (dealerList[1] == playerList[1]) judje.strike++;
        if (dealerList[2] == playerList[2]) judje.strike++;

        if (dealerList[0] == playerList[1]) judje.ball++;
        if (dealerList[0] == playerList[2]) judje.ball++;
        if (dealerList[1] == playerList[0]) judje.ball++;
        if (dealerList[1] == playerList[2]) judje.ball++;
        if (dealerList[2] == playerList[0]) judje.ball++;
        if (dealerList[2] == playerList[1]) judje.ball++;

        return judje;
    }
}
