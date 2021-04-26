package gamelogic;

import java.util.Random;

public class Game {
    private final Random random = new Random();

    public void runNewGame() {
        int ans = generateAnswer();
    }

    private int generateAnswer(){
        int answerCandidate = generateAnswerCandidate();
        while (!isValidAnswer(answerCandidate)){
            answerCandidate = generateAnswerCandidate();
        }
        return answerCandidate;
    }

    private int generateAnswerCandidate() {
        int candidate = 0;
        for (int i = 0; i < 3; i++) {
            candidate = candidate * 10 + (random.nextInt(9)+ 1);
        }
        return candidate;
    }

    private boolean isValidAnswer(int candidate){
        int first = candidate / 100;
        int second =  (candidate / 10) % 10 ;
        int third = candidate % 10;
        return (first != second && second != third && third != first);
    }
}
