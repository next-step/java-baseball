package domain;

import java.util.Random;

public class DefensePlayer {

    private Numbers answer;

    public DefensePlayer(){}

    public Numbers decideAnswerNumber() {
        answer = new Numbers();
        while(answer.getDigits().size()<Numbers.MAX_SIZE){
            answer.add(generateRandomNumber());
        }
        return answer;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public Numbers getAnswer() {
        return answer;
    }
}
