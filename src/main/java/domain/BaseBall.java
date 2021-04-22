package domain;

import java.util.HashMap;


public class BaseBall {
    public static final Integer INCLUSIVE_MIN = 1;
    public static final Integer INCLUSIVE_MAX = 9;
    public static final Integer TRUE = 1;
    public static final Integer FALSE = 0;

    private static HashMap<Info, BaseBall> cachedBaseBalls = new HashMap<Info, BaseBall>();

    private final int number;
    private final int location;

    private BaseBall(int number, int location) {
        this.number = number;
        this.location = location;
    }


    public static BaseBall fromNumAndLocation(int number, int location) {
        Info info = new Info(number, location);

        if(!cachedBaseBalls.containsKey(info)) {
            cachedBaseBalls.put(info, new BaseBall(number, location));
        }
        return cachedBaseBalls.get(info);
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

    public boolean isSameLocation(BaseBall opponent) {
        return location == opponent.location;
    }

    public int ballScore(BaseBall answer) {
        if(!isSameLocation(answer)) {
            return isEqualNumber(answer);
        }
        return 0;
    }

}
