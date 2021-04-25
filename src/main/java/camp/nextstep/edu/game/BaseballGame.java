package camp.nextstep.edu.game;

import java.util.Scanner;

public class BaseballGame implements Game {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        BaseballNumber baseballNumber = BaseballNumber.generateBaseballNumber();
        BaseballGameResult result;
        do {
            result = play(baseballNumber);
            System.out.println(result.toString());
        } while (result.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        // TODO: 게임 다시 시작 및 게임 종료
    }

    private BaseballGameResult play(BaseballNumber baseballNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.next();
        if (BaseballNumber.isValidBaseballNumber(input)) {
            BaseballNumber inputBaseballNumber = BaseballNumber.of(input);
            return baseballNumber.compare(inputBaseballNumber);
        }
        System.out.println("유효하지 않은 입력 값입니다");
        return play(baseballNumber);
    }
}
