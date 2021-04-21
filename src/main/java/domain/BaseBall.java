package domain;

import java.util.HashMap;

public class BaseBall {
    public static final Integer INCLUSIVE_MIN = 1;
    public static final Integer INCLUSIVE_MAX = 9;
    private static final HashMap<Integer, BaseBall> cachedBaseBall = new HashMap<>();

    private final int number;

    public BaseBall(int number) {
        this.number = number;
    }

    public static boolean isValidate(int number) {
        return INCLUSIVE_MIN <= number && number <= INCLUSIVE_MAX;
    }


}
