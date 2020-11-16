import java.util.Scanner;

public class BaseballGame {

    private static String questionNumber = "";

    static Scanner scanner = new Scanner(System.in);
    private static final String answerNumber = "";

    public static void main(String[] args) {

        boolean result;
        do {
            result = run();
        } while (result && quit());
    }

    public static boolean quit() {

        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = scanner.nextLine();
        return "1".equals(number);
    }

    public static boolean run() {

        BaseballGame game = new BaseballGame();
        game.start();

        String answerNumber = "";
        boolean isCorrected = false;
        while (!isCorrected) {
            System.out.print("숫자를 입력해주세요. : ");
            answerNumber = scanner.nextLine();
            isCorrected = game.answer(answerNumber);
        }

        return true;
    }


    public void start() {
        System.out.println("야구게임시작");
        questionNumber = new Question().generate();
        System.out.println("questionNumber: " + questionNumber);
    }

    public boolean answer(String answerNumber) {

        Answer answer = new Answer(questionNumber);

        if (!answer.isValid(answerNumber)) {
            return false;
        }

        // 볼카운트 확인
        return answer.getBallCount(answerNumber);
    }


}
