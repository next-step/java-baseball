import game.GameMachine;
import game.ResultStatus;

import java.util.Scanner;

public class Main {

    public final static int ANSWER = 3;

    public static void main(String[] args) {
        GameMachine gameMachine = GameMachine.of();
        gameMachine.init(new int[]{1, 2, 3});

        boolean isExit = false;
        while (!isExit)
            isExit = runningGame(gameMachine);
    }

    private static boolean runningGame(GameMachine gameMachine) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("숫자를 입력해주세요 : ");
            String[] input = sc.nextLine().split(" ");
            gameMachine.isValid(input);

            int[] result = gameMachine.check(input);
            System.out.println(gameMachine.print(result));

            return checkAnswer(gameMachine, result);

        } catch (IllegalStateException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        return false;
    }

    private static boolean checkAnswer(GameMachine gameMachine, int[] result) {
        if (result[ResultStatus.STRIKE.getIndex()] == ANSWER) {
            System.out.println("모두 맞히졌습니다.");
            return true;
        }
        return false;
    }
}
