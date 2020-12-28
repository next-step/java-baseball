import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
    private Scanner sc;

    private int answerHundreds;
    private int answerTens;
    private int answerOnes;

    private int strike;
    private int ball;

    public int getAnswerHundreds() {
        return answerHundreds;
    }

    public int getAnswerTens() {
        return answerTens;
    }

    public int getAnswerOnes() {
        return answerOnes;
    }

    public BaseBallGame() {
        sc = new Scanner(System.in);
        answerHundreds = 0;
        answerTens = 0;
        answerOnes = 0;
        strike = 0;
        ball = 0;
    }

    public void run() {
        while(playGame() == 1) {}
    }

    public int playGame() {
        setAnswer();

        return 0;
    }

    public void setAnswer() {
        Random random = new Random();
        answerHundreds = random.nextInt(9) + 1;
        while(answerHundreds == answerTens || answerTens == 0) {
            answerTens = random.nextInt(9) + 1;
        }
        while((answerHundreds == answerOnes) || (answerTens == answerOnes) || answerOnes ==0) {
            answerOnes = random.nextInt(9) + 1;
        }
    }

}
