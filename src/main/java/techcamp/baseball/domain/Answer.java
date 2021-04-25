package techcamp.baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {

    private final List<Integer> numbers;
    private int strikeCount;
    private int ballCount;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    //==생성 메서드==//
    public Answer(String input) {
        List<String> strInputs = new ArrayList<>(Arrays.asList(input.split("")));
        List<Integer> numbers = new ArrayList<>();

        for (String strInput : strInputs) {
            numbers.add(Integer.valueOf(strInput));
        }
        this.numbers = numbers;
    }

    //==비즈니스 메서드==//
    public void addBall(){
        this.ballCount += 1;
    }

    public void removeBall(){
        this.ballCount -= 1;
    }

    public void addStrike(){
        this.strikeCount += 1;
    }

    //==조회 메서드==//
    public String getCountResult() {
        String message = "";
        if(this.strikeCount > 0) {
            message += this.strikeCount + " 스트라이크 ";
        }
        if(this.ballCount > 0) {
            message += this.strikeCount + " 볼";
        }
        if (this.strikeCount + this.ballCount == 0) {
            message += "낫싱";
        }
        return message;
    }
}
