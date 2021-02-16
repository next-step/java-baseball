package domain;

public abstract class Player {
    private BaseballNumberBundle baseballNumberBundle;

    protected Player() {
        baseballNumberBundle = new BaseballNumberBundle(pickBaseballNumbers());
    }

    protected abstract int pickBaseballNumbers();

    public BaseballNumberBundle getBaseballNumberBundle() {
        return baseballNumberBundle;
    }
}
