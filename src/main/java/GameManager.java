import java.util.List;

public class GameManager {

    private static BaseBall answer;
    private static final InputHandler inputHandler = new InputHandler();

    public static void main(String[] args) {
        do {
            answer = new BaseBall();
            repeatUntilFindAnswer();
        }
        while (isGameContinue());
    }

    private static void repeatUntilFindAnswer() {
        boolean isFindAnswer = false;
        while (!isFindAnswer) {
            Respond res = isCorrect();
            isFindAnswer = isThreeStrikes(res);
            // view : 힌트 출 (x 스트라이크, y 볼)
            System.out.println(res);
        }
        // view : 3개의 숫자를 모두 맞히셨습니! 게임 종료
        System.out.println(Messages.findAnswerMessage);
    }

    private static Respond isCorrect() {
        // view : 숫자를 입력해주세요.
        System.out.print(Messages.numberInputMessage);
        List<Integer> userRequest = null;
        try {
            userRequest = inputHandler.getUserRequest();
        } catch (Exception e) {
            // view : [에러] 유효하지 않은 입력으로 인해 게임을 종료합니다.
            System.out.println(Messages.errorMessage);
        }
        return answer.calculate(userRequest);
    }

    private static boolean isThreeStrikes(Respond respond) {
        return respond.getStrikes() == 3;
    }

    private static boolean isGameContinue() {
        // view : 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
        System.out.println(Messages.endOrContinueMessage);
        Command userCommand = null;
        try {
            userCommand = inputHandler.getUserCommand();
        } catch (Exception e) {
            // view : [에러] 유효하지 않은 입력으로 인해 게임을 종료합니다.
            System.out.println(Messages.errorMessage);
        }
        return userCommand.equals(Command.CONTINUE);
    }

}
