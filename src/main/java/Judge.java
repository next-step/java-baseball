public class Judge {
    public Result getResult(int userTurn, int computerTurn) {
        int strikeCounts = getStrikeCounts(userTurn, computerTurn);
        int ballCounts = getBallCounts(userTurn, computerTurn);

        return new Result(strikeCounts, ballCounts);
    }
    public int getStrikeCounts(int userTurn, int computerTurn) {
        int counts = 0;
        counts += userTurn / 100 == computerTurn / 100 ? 1 : 0;
        counts += userTurn / 10 % 10 == computerTurn / 10 % 10 ? 1 : 0;
        counts += userTurn % 10 == computerTurn % 10 ? 1 : 0;

        return counts;
    }
    public int getBallCounts(int userTurn, int computerTurn) {
        int counts = 0;
        counts += userTurn / 100 == computerTurn / 10 % 10 ||
                userTurn / 100 == computerTurn % 10 ? 1 : 0;
        counts += userTurn / 10 % 10 == computerTurn / 100 ||
                userTurn / 10 % 10 == computerTurn % 10 ? 1 : 0;
        counts += userTurn % 10 == computerTurn / 100 ||
                userTurn % 10 == computerTurn / 10 % 10 ? 1 : 0;

        return counts;
    }
}
