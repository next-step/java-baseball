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
}
