package baseball.domain;

import java.util.*;

public class UserNumber {

    public Ball ball;

    public void UserNumber(){
        System.out.print("숫자를 입력해 주세요 : ");

        Scanner scanner = new Scanner(System.in);
        ball = new Ball(scanner.nextLine());
    }

}
