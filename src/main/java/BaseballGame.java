import java.util.*;

public class BaseballGame {

    private int [] answer;
    private int [] userAnswer;
    private final int SIZE_INPUT = 3;
    private final Scanner sc;
    public BaseballGame() {
        this.answer = new int[SIZE_INPUT];
        this.userAnswer  = new int[SIZE_INPUT];
        sc = new Scanner(System.in);
    }


    private void setRandomAnswer() {
        int number;
        int i=0;
        while (i<SIZE_INPUT) {
            number = (int) (Math.random()*9+1);
            if (!isAlreadySet(number)) {
                answer[i] = number;
                i++;
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
        boolean isAllStrike;
        while (true) {
            isAllStrike = false;

            setRandomAnswer();
            while (!isAllStrike) {
                isAllStrike = startPhase();
            }
            if (checkGameEnd()) {
                break;
            }
        }

    }

    private boolean startPhase() {
        do {
            getUserInput();
        } while (isWrongInputs());
        return checkAnswer();
    }

    private void getUserInput() {
        System.out.print("숫자 3개를 입력하세요: ");

        int num;


        for (int i = 0; i<SIZE_INPUT; i++) {
            num = sc.nextInt();
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
        boolean isEnd = printResult(strikes,balls);
        return isEnd;
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
            if(answer[i] == userAnswer[j] && i != j) {
                return true;
            }
        }
        return false;
    }
    private boolean printResult(int strikes,int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫씽!");
        }
        else if (strikes == 0) {
            System.out.println(balls+" 볼");
        }
        else if (balls == 0) {
            System.out.println(strikes+" 스트라이크");
        }
        else {
            System.out.println(strikes+" 스트라이크 "+balls+" 볼");
        }

        if (strikes == SIZE_INPUT) {
            System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }

    private boolean checkGameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요. ");
        int input;
        while (true) {
            input = sc.nextInt();
            if (input == 1) {
                return false;
            }
            else if (input == 2) {
                return true;
            }
            else {
                System.out.println("1 혹은 2를 입력해주세요.");
            }
        }

    }
}
