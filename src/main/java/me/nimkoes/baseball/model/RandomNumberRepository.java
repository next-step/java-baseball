package me.nimkoes.baseball.model;

public class RandomNumberRepository {
    private static RandomNumberRepository randomNumberRepository = new RandomNumberRepository();

    private RandomNumberRepository() {}

    public static RandomNumberRepository getInstance() {
        return randomNumberRepository;
    }

    private String targetNumber;

    public String getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }

}
