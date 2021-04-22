package domain;

import java.util.HashMap;

public class BaseBall {
    public static final Integer INCLUSIVE_MIN = 1;
    public static final Integer INCLUSIVE_MAX = 9;
    public static final Integer TRUE = 1;
    public static final Integer FALSE = 0;

    private static final HashMap<Integer, BaseBall> cachedBaseBall = new HashMap<>();

    private final int number;

    private BaseBall(int number) {
        this.number = number;
    }

    public static BaseBall fromNumber(int number) {
        if(!cachedBaseBall.containsKey(number)) {
            cachedBaseBall.put(number, new BaseBall(number));
        }
        return cachedBaseBall.get(number);
    }

    public static boolean isValidate(int number) {
        return INCLUSIVE_MIN <= number && number <= INCLUSIVE_MAX;
    }

    public int isEqualNumber(BaseBall opponent) {
        if(number == opponent.number) {
            return TRUE;
        }
        return FALSE;
    }

}
