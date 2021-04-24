public class Rule {
    private static final int DIGIT = 3;

    public static boolean isValid(int[] numList) {
        if (numList == null) return false;
        if (numList.length != 3) return false;
        return ((numList[0] != numList[1]) && (numList[1] != numList[2]) && (numList[2] != numList[0]));
    }

    public static boolean doesWin(Judge judge) {
        return (judge.strike == 3);
    }

    public static Judge judge(int[] dealerList, int[] playerList) {
        if (!isValid(dealerList)) return null;
        if (!isValid(playerList)) return null;

        Judge judge = new Judge();

        if (dealerList[0] == playerList[0]) judge.strike++;
        if (dealerList[1] == playerList[1]) judge.strike++;
        if (dealerList[2] == playerList[2]) judge.strike++;

        if (dealerList[0] == playerList[1]) judge.ball++;
        if (dealerList[0] == playerList[2]) judge.ball++;
        if (dealerList[1] == playerList[0]) judge.ball++;
        if (dealerList[1] == playerList[2]) judge.ball++;
        if (dealerList[2] == playerList[0]) judge.ball++;
        if (dealerList[2] == playerList[1]) judge.ball++;

        return judge;
    }
}
