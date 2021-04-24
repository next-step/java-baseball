import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BaseBall bbs = new BaseBall();
        String goal = bbs.unique3DigitString();

        boolean going = true;
        Scanner scanner = new Scanner(System.in);

        while (going) {
            System.out.print("숫자를 입력해주세요: ");
            String input = scanner.nextLine();

            Map<String, Integer> resultMap = bbs.judgeBaseBall(goal, input);
            bbs.printMsg(resultMap);

            boolean finish = bbs.judgeFinish(resultMap.get("STRIKE"));
            boolean restart = bbs.continueOrBreak(finish);

            goal = bbs.resetGoal(restart, goal);
            going = !finish || restart;
        }
    }

}
