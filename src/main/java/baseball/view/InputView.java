package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseball.domain.Ball;
import baseball.domain.Balls;

public class InputView {
    public static Balls balls() {
        System.out.println("숫자를 입력해주세요 : ");

        byte[] numbers = new Scanner(System.in)
                .nextLine()
                .getBytes();

        List<Ball> balls = new ArrayList<>();
        for (byte number : numbers) {
            balls.add(Ball.of(number - '0'));
        }

        return new Balls(balls);
    }

    public static Continuable moreGame() {
        System.out.println(
                String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요",
                        Continuable.CONTINUE.getKeyword(),
                        Continuable.BREAK.getKeyword())
        );

        String answer = new Scanner(System.in).nextLine();

        if (answer.equals(Continuable.CONTINUE.getKeyword())) {
            return Continuable.CONTINUE;
        } else if (answer.equals(Continuable.BREAK.getKeyword())) {
            return Continuable.BREAK;
        }

        return Continuable.UNKNOWN;
    }
}
