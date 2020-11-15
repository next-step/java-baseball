package baseball.game.view;

import baseball.game.domain.game.BaseBallGame;
import baseball.game.domain.game.BaseBallGameResultType;
import baseball.game.domain.generator.DirectBallsGenerator;
import baseball.game.domain.generator.RandomBallsGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args) {
        BaseBallGame baseBallGame = BaseBallGame.createGame(RandomBallsGenerator.generate());
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scanner.next();

            List<Integer> numbers = new ArrayList<>();
            for(String number: input.split("")) {
                numbers.add(Integer.parseInt(number));
            }

            BaseBallGameResultType result = baseBallGame.getResult(DirectBallsGenerator.generate(numbers));
            System.out.println(result.getPrintString());

            if(result == BaseBallGameResultType.THREE_STRIKE) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }

        }
    }
}
