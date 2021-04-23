import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallPlayer {

    public static void play() {
        Scanner scan = new Scanner(System.in);
        BaseBall game = new BaseBall();
        boolean isFinish = false;
        while (!isFinish) {
            List<Integer> userAnswer = askAnswer(scan);
            BaseBallDto.Result result = game.getUserResult(userAnswer);
            printResultMessage(result);
            if (result.getIsAnswer()) {
                isFinish = game.finish(askFinish(scan));
            }
        }
        scan.close();
    }

    private static List<Integer> askAnswer(Scanner scan) {
        List<Integer> converted = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String[] userResponse = String.valueOf(scan.nextInt()).split("");
        for (int i = 0; i < userResponse.length; ++i) {
            converted.add(Integer.valueOf(userResponse[i]));
        }

        return converted;
    }

    private static boolean askFinish(Scanner scan) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userResponse = scan.nextInt();
        if (userResponse == 1) {
            return false;
        }
        return true;
    }

    private static void printResultMessage(BaseBallDto.Result result) {
        StringBuilder message = new StringBuilder();
        if (result.getStrike() + result.getBall() < 1) {
            message.append("낫싱");
        }
        if (result.getStrike() > 0) {
            message.append(result.getStrike() + " 스트라이크 ");
        }
        if (result.getBall() > 0) {
            message.append(result.getBall() + " 볼");
        }
        System.out.println(message.toString().trim());
        if (result.getIsAnswer()) {
            System.out.println(result.getStrike() + "개의 숫자를 모두 맞추셨습니다! 게임 종료");
        }
    }
}
