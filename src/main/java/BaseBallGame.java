import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallGame {
    private boolean isRunning;
    Message message;
    int strike;
    int ball;
    int[] answer;

    public BaseBallGame(Message message) {
        this.message = message;
        this.resetGame();
    }

    public void resetGame() {
        resetStrikeBall();
        this.answer = this.createAnswer();

        this.setRunning(true);
    }

    private void resetStrikeBall() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public String getInput() {
        message.getInput();

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        return input;
    }

    private int[] createAnswer() {
        ArrayList<Integer> temp_array = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
                add(8);
                add(9);
            }
        };
        int max_idx = temp_array.size();

        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            int remove_idx = this.getRandomNum(max_idx);
            answer[i] = temp_array.get(remove_idx);
            temp_array.remove(remove_idx);
            max_idx--;
        }
        return answer;
    }

    private int getRandomNum(int max_idx) {
        double random = Math.random();
        int random_idx = (int)(random * max_idx);

        return random_idx;
    }

    public void checkAnswer(String input) {
        if (this.isNumber(input) && this.checkInputThreeLength(input)) {
            int[] answer = this.createIntArray(input);
            this.check(answer);
        }
    }

    private void check(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            this.checkNumber(answer[i], i);
        }

        message.getResult(this.strike, this.ball);

        if (this.strike == 3) {
            message.gameOver();
            this.askContinue();
            return;
        }

        this.resetStrikeBall();
    }

    private void askContinue() {
        message.askContinue();

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        if (this.isNumber(input) && input.equals("1")) {
            this.resetGame();
            return;
        }
        this.setRunning(false);
    }

    private void checkNumber(int number, int index) {
        for (int i = 0; i < this.answer.length; i++) {
            this.checkStrikeBall(number, index, this.answer[i] , i);
        }
    }

    private void checkStrikeBall(int number, int index, int answer_number, int answer_index) {
        if (number == answer_number && index == answer_index) {
            this.strike++;
        }

        if (number == answer_number && index != answer_index) {
            this.ball++;
        }
    }

    private int[] createIntArray(String input) {
        int[] result = new int[3];

        for (int i = 0; i < input.length() ; i++) {
            result[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return result;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            message.notNumber();
            return false;
        }
        return true;
    }

    private boolean checkInputThreeLength(String input) {
        if (input.length() != 3) {
            message.notThreeNumber();
            return false;
        }
        return true;
    }
}
