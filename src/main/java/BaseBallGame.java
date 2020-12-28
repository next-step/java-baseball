import java.util.InputMismatchException;
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

    public int getStrike() {
        return strike;
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
        do {
            int userNumber = getUserNumber();
            checkNumber(userNumber);
        } while(getStrike() != 3);
        return 0;
    }

    public void checkNumber(int Number) {
        int userHundreds = Number / 100;
        int userTens = (Number % 100) / 10;
        int userOnes = Number % 10;
        checkStrike(userHundreds, userTens, userOnes);
        checkBall(userHundreds, userTens, userOnes);
    }

    public void checkStrike(int userHundreds, int userTens, int userOnes) {
        strike = 0;
        if(answerHundreds == userHundreds) {
            strike++;
        }
        if(answerTens == userTens) {
            strike++;
        }
        if(answerOnes == userOnes) {
            strike++;
        }
    }

    public void checkBall(int userHundreds, int userTens, int userOnes) {
        ball = 0;
        if(userHundreds == answerTens || userHundreds == answerOnes) {
            ball ++;
        }
        if(userTens == answerHundreds || userTens == answerOnes) {
            ball ++;
        }
        if(userOnes == answerHundreds || userOnes == answerTens) {
            ball ++;
        }
    }

    public int getNumber() {
        try {
            int command = sc.nextInt();
            return command;
        } catch (InputMismatchException e) {
            sc = new Scanner(System.in);
            return 0;
        }
    }

    public int getUserNumber() {
        int number;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            number = getNumber();
        } while(number > 999 || number < 100);
        return number;
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
