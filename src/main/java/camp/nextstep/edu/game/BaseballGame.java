package camp.nextstep.edu.game;

import java.util.Scanner;

public class BaseballGame implements Game {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        BaseballNumber baseballNumber = BaseballNumber.generateBaseballNumber();
        play(baseballNumber);
    }

    private BaseballGameResult play(BaseballNumber baseballNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.next();
        if (BaseballNumber.isValidBaseballNumber(input)) {
            return baseballNumber.compare(input);
        }
        System.out.println("유효하지 않은 입력 값입니다");
        return play(baseballNumber);
    }
}
