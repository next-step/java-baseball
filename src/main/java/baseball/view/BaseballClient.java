package baseball.view;

import baseball.util.BaseballUtil;

import java.util.Scanner;

public class BaseballClient {
    BaseballUtil util = new BaseballUtil();
    Scanner sc = new Scanner(System.in);

    public int displayGameOption(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int option = sc.nextInt();
        return option;
    }

    public String getUserinput(){
        System.out.println("숫자를 입력해주세요: ");
        String input = sc.next();

        return input;
    }

    public void displayGameResult(String rs){
        System.out.println(rs);
    }

    public void displayFinishMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 개임 종료");
    }
}
