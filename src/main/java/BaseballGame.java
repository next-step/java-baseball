import java.util.*;

public class BaseballGame {

    private int [] answer;
    private int [] userAnswer;
    private final int SIZE_INPUT = 3;
    public BaseballGame() {
        this.answer = new int[SIZE_INPUT];
        this.userAnswer  = new int[SIZE_INPUT];
    }
    private void setRandomAnswer() {
        int number;

        for (int i=0; i<SIZE_INPUT; i++) {
            number = (int) (Math.random()*9+1);
            if (!isAlreadySet(number)) {
                answer[i] = number;
            }
        }
    }
    private boolean isAlreadySet( int number) {
        for(int i=0; i<SIZE_INPUT; i++) {
            if (answer[i] == number) {
                return true;
            }
        }
        return false;
    }
    public void start() {
        setRandomAnswer();
        do {
            getUserInput();
        } while (isWrongInputs());

    }

    private void getUserInput() {
        System.out.println("숫자 3개를 입력하세요.");

        int num;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i<SIZE_INPUT; i++) {
            num = input.nextInt();
            userAnswer[i] = num;
        }


    }
    private boolean isWrongInputs() {
        for (int i = 0; i<SIZE_INPUT; i++) {
            if(!isPermittedNumber(userAnswer[i])) {
                System.out.println("주의:: 1~9 의 숫자를 입력해주세요!");
                return true;
            }
            else {
                continue;
            }
        }
        if (isOverlap()) {
            System.out.println("주의:: 중복되지 않은 답을 입력해주세요!");
            return true;
        }

        return false;
    }

    private boolean isPermittedNumber(int num) {
        return 0 < num && num < 10;
    }
    private boolean isOverlap() {
        for(int i=0; i<SIZE_INPUT; i++) {
            if(equalsTwoNumber(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean equalsTwoNumber(int i) {
        for (int j=i+1; j<SIZE_INPUT; j++) {
            if(userAnswer[i] == userAnswer[j])  {
                return true;
            }
        }
        return false;
    }

    private boolean checkAnswer() {
        int strikes = countStrikes();
        int balls = countBalls();
        if (strikes == 0 && balls == 0) {
            System.out.println("낫씽!");
            return false;
        }
        return true;
    }
    private int countStrikes() {
        int numOfStrike = 0;
        for(int i=0; i<SIZE_INPUT; i++) {
            if(answer[i] == userAnswer[i]) {
                numOfStrike ++;
            }
        }
        return numOfStrike;
    }
    private int countBalls() {
        int numOfBall = 0;
        for(int i=0; i<SIZE_INPUT; i++) {
            if(isBall(i)) {
                numOfBall++;
            }
        }
        return numOfBall;
    }
    private boolean isBall(int i) {
        for(int j=0; j<SIZE_INPUT; j++) {
            if(answer[i] == answer[j] && i != j) {
                return true;
            }
        }
        return false;
    }
}
