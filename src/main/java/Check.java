public class Check {
    public static boolean validationCheck(int turn) {
        if (!rangeCheck(turn)) {
            return false;
        }
        if (!zeroDigitCheck(turn)) {
            return false;
        }
        if (!sameDigitCheck(turn)) {
            return false;
        }

        return true;
    }
    private static boolean rangeCheck(int turn) {
        return 123 <= turn && turn <= 987;
    }
    private static boolean zeroDigitCheck(int turn) {
        if (turn % 10 == 0) {
            return false;
        }
        if (turn / 10 % 10 == 0) {
            return false;
        }
        if (turn / 100 == 0) {
            return false;
        }
        return true;
    }
    private static boolean sameDigitCheck(int turn) {
        int counts = 0;
        counts += turn / 100 == turn / 10 % 10 ? 1 : 0;
        counts += turn / 100 == turn % 10 ? 1 : 0;
        counts += turn / 10 % 10 == turn % 10 ? 1 : 0;

        return counts == 0;
    }
}
