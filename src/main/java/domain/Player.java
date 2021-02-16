package domain;

import static domain.BaseballNumberBundle.DEFAULT_BUNDLE_NUMBER;

public class Player {
    private BaseballNumberBundle baseballNumberBundle;

    protected Player() {
        baseballNumberBundle = new BaseballNumberBundle(pickBaseballNumbers());
    }

    public Player(int number){
        baseballNumberBundle = new BaseballNumberBundle(number);
    }

    protected int pickBaseballNumbers(){
        return DEFAULT_BUNDLE_NUMBER;
    }

    public BaseballNumberBundle getBaseballNumberBundle() {
        return baseballNumberBundle;
    }
}
