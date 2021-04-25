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

    private static int judgeStrike(int[] dealerList, int[] playerList) {
        int strike = 0;

        if (dealerList[0] == playerList[0]) strike++;
        if (dealerList[1] == playerList[1]) strike++;
        if (dealerList[2] == playerList[2]) strike++;

        return strike;
    }

    private static int judgeBall(int[] dealerList, int[] playerList) {
        int ball = 0;

        if (dealerList[0] == playerList[1]) ball++;
        if (dealerList[0] == playerList[2]) ball++;
        if (dealerList[1] == playerList[0]) ball++;
        if (dealerList[1] == playerList[2]) ball++;
        if (dealerList[2] == playerList[0]) ball++;
        if (dealerList[2] == playerList[1]) ball++;

        return ball;
    }

    public static Judge judge(int[] dealerList, int[] playerList) {
        Judge judge = new Judge();
        judge.strike = judgeStrike(dealerList, playerList);
        judge.ball = judgeBall(dealerList, playerList);

        return judge;
    }
}
