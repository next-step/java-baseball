import game.GameMachine;
import game.ResultStatus;

import java.util.Scanner;

public class Main {

    public final static int RESTART = 1;
    public final static int EXIT = 2;
    public final static int NONE = -1;
    public final static int ANSWER = 3;

    public static void main(String[] args) {
        GameMachine gameMachine = GameMachine.of();
        gameMachine.init();

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
            return restart(gameMachine);
        }
        return false;
    }

    private static boolean restart(GameMachine gameMachine) {
        Scanner sc = new Scanner(System.in);
        int option = NONE;

        while (option == NONE) {
            System.out.println("게임을 새로 시작하려면 1, 종려하려면 2를 입력하세요.");
            String input = sc.nextLine();
            option = selectOption(input);
        }

        if (option == RESTART)
            gameMachine.init();

        return option == EXIT;
    }

    private static int selectOption(String input) {
        String regExp = "^[1-2]";
        if (input.matches(regExp))
            return Integer.parseInt(input);

        return NONE;
    }
}
