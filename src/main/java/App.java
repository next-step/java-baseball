import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private RandomUtil randomUtil = new RandomUtil();
    private InputHandler inputHandler = new InputHandler();
    private GameLogic gameLogic = new GameLogic();

    public void start() {
        boolean success = false;
        List<Integer> initNum = this.getInitNum();
        System.out.println("initNum : "+initNum);
        while (!success) {
            // get Input
            System.out.println("숫자를 입력해주세요 :");
            int input = scanner.nextInt(10);
            inputHandler.isValidateInputRange(input);
            List<Integer> inputList = inputHandler.splitInput(input);

            // do compare
            int strike = gameLogic.compareSameIndex(initNum, inputList);
            int ball = gameLogic.compareDiffIndex(initNum, inputList);
            String output = this.getOutputString(strike, ball);
            System.out.println(output);

            success = this.getResult(strike);
        }
    }

    private List<Integer> getInitNum() {
        boolean isNormal = false;
        List<Integer> initNum = new ArrayList<>();
        while (!isNormal) {
            initNum.clear();
            initNum.add(randomUtil.getRandom(1, 9));
            initNum.add(randomUtil.getRandom(1, 9));
            initNum.add(randomUtil.getRandom(1, 9));
            isNormal = !randomUtil.IsDuplicatedNumList(initNum);
        }
        return initNum;
    }

    private String getOutputString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + " 볼";
        }
        if (ball == 0) {
            return strike + " 스트라이크";
        }
        return strike + " 스트라이크" + ball + " 볼";
    }

    private boolean getResult(int strike) {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
