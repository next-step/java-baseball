import java.util.*;

public class BaseballGame {

    private int [] answer;

    public BaseballGame() {
        this.answer = new int[3];

    }
    private void setRandomAnswer() {
        int number;

        for (int i=0; i<3; i++) {
            number = (int) (Math.random()*10+1);
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
    }

    private void getUserInput() {
        System.out.println("숫자 3개를 입력하세요.");
        int [] userAnswers = new int[3];
        int num;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i<3; i++) {
            num = input.nextInt();
            userAnswers[i] = num;
        }




        System.out.println("연산자를 입력하세요.");

    }
    private boolean isPermittedNumber(int num) {
        if (0 < num && num < 10) {
            return true;
        }
        else return false;
    }
}
