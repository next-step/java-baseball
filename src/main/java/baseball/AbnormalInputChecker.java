package baseball;

public class AbnormalInputChecker {
    public Boolean isAbnormal(char[] targetChars) {
        int abnormalCnt = 0;

        for (int i = 0; i < targetChars.length; i++) {
            abnormalCnt += this.validateAbnormal(targetChars[i]);
        }

        return abnormalCnt != 0;
    }

    private int validateAbnormal(char c) {
        return (c < '1' || c > '9') ? 1 : 0;
    }
}
