package me.lozm.baseball.entity;

public class BaseballComputer {

    private BaseballNumber baseballNumber;
    private String answer;


    public BaseballComputer() {
        this.baseballNumber = new BaseballNumber();
    }

    public String getAnswer() {
        return answer;
    }

    public void createAnswer() {
        this.answer = baseballNumber.getRandomNumberToString();
    }

}