import java.util.Scanner;

public class UserInterface {

    private boolean isGameFinished = false;
    private final String QUIZ_MESSAGE = "숫자를 입력주세요 : ";
    private final int ANSWER_LENGTH = 3;

    private QuizGenerator quizGenerator = new QuizGenerator(ANSWER_LENGTH);

    public void run() {
        while(!isGameFinished) {
            isGameFinished = playGame();
        }

        System.exit(0);
    }

    private boolean playGame() {
        int inputNumber = 0;
        int answerNumber = quizGenerator.generate();
        Scanner sc = new Scanner(System.in);
        CountChecker countChecker = new CountChecker(answerNumber);

        System.out.println("테스트용 정답 출력 : " + answerNumber);

        while(inputNumber != answerNumber) {
            printQuizMessage();
            inputNumber = sc.nextInt();
            countChecker.check(inputNumber);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        inputNumber = sc.nextInt();

        return inputNumber != 1;
    }

    private void printQuizMessage() {
        System.out.print(QUIZ_MESSAGE);
    }
}
