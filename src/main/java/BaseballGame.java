import java.util.*;

public class BaseballGame {

    private int [] answer;
    private int [] userAnswer = new int[3];
    public BaseballGame() {
        this.answer = new int[3];

    }
    private void setRandomAnswer() {
        int number;

        for (int i=0; i<3; i++) {
            number = (int) (Math.random()*9+1);
            if (!isAlreadySet(number)) {
                answer[i] = number;
            }
        }
    }
    private boolean isAlreadySet( int number) {
        for(int i=0; i<3; i++) {
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

        for (int i = 0; i<3; i++) {
            num = input.nextInt();
            userAnswer[i] = num;
        }


    }
    private boolean isWrongInputs() {
        for (int i = 0; i<3; i++) {
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
        for(int i=0; i<3; i++) {
            if(equalsTwoNumber(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean equalsTwoNumber(int i) {
        for (int j=i+1; j<3; j++) {
            if(userAnswer[i] == userAnswer[j])  {
                return true;
            }
        }
        return false;
    }
}
