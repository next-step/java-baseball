package baseball.view;

import baseball.domain.Ball;
import baseball.domain.Balls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static Balls balls() {
        System.out.println("숫자를 입력해주세요 : ");
        byte[] numbers = new Scanner(System.in)
                .nextLine()
                .getBytes();

        List<Ball> balls = new ArrayList<>();
        for(byte number : numbers) {
            balls.add(Ball.of(number - '0'));
        }

        return new Balls(balls);
    }

    public static Continuable moreGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String answer = new Scanner(System.in).nextLine();

        if(answer.equals("1")) {
            return Continuable.CONTINUE;
        }else if(answer.equals("2")) {
            return Continuable.BREAK;
        }

        return Continuable.UNKNOWN;
    }
}
