import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BaseBall bbs = new BaseBall();
        String goal = bbs.unique3DigitString();

        boolean finish = true;
        Scanner scanner = new Scanner(System.in);

        while (finish) {
            System.out.print("숫자를 입력해주세요: ");
            String input = scanner.nextLine();

            boolean checkInput = bbs.checkUnique3DigitString(input);
            Map<String, Integer> resultMap = bbs.judgeBaseBall(goal, input);
        }
    }

}
