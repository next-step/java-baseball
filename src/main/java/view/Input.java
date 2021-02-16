package view;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    private static final String INPUT_NUMBER_MSG = "숫자를 입력해 주세요";
    private static final String INPUT_NEXT_GAME_MSG = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";
    private static final Scanner scanner = new Scanner(System.in);

    enum Answer {
        YES("1", true),
        NO("2", false);

        private final String input;
        private final boolean status;

        Answer(String input, boolean status) {
            this.input = input;
            this.status = status;
        }

        private static Answer of(final String input) {
            return Arrays
                .stream(Answer.values())
                .filter(answer -> answer.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unexpected input"));
        }

        public String getInput() {
            return input;
        }

        public boolean getStatus() {
            return status;
        }
    }

    public String getNumber() {
        System.out.println(INPUT_NUMBER_MSG);
        return scanner.nextLine();
    }

    public boolean getNextGame() {
        System.out.format(INPUT_NEXT_GAME_MSG, Answer.YES, Answer.NO);
        return Answer.of(scanner.nextLine()).getStatus();
    }
}
