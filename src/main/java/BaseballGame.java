import java.util.Scanner;

public class BaseballGame {
    private Scanner scanner = new Scanner(System.in);
    private boolean isSolved;
    private Question question;

    public BaseballGame() {
        init();
    }

    private boolean isPlaying() {
        if (!isSolved) {
            return true;
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        if (input.equals("2")) {
            return false;
        }
        init();
        return true;
    }

    private void init() {
        isSolved = false;
        question = new Question();
    }

    private void judge(String answer) {
        JudgeResult judgeResult = question.judge(answer);
        printJudge(judgeResult);
        isSolved = judgeResult.isSolved();
    }

    private void printJudge(JudgeResult judgeResult) {
        if (judgeResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (judgeResult.getStrike() != 0)
            System.out.print(judgeResult.getStrike() + " 스트라이크 ");
        if (judgeResult.getBall() != 0)
            System.out.print(judgeResult.getBall() + "볼");
        System.out.println();
    }

    public void run() {
        while (isPlaying()) {
            System.out.print("숫자를 입력해주세요 : ");
            judge(scanner.nextLine());
        }
    }
}
