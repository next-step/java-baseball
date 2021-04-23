package nextstep.baseball.service;

import java.util.Scanner;

public class BaseballGame {
    private final BaseballGameNumberService baseballGameNumberService;
    private final BaseballGameCheckService baseballGameCheckService;

    public BaseballGame(BaseballGameNumberService baseballGameNumberService, BaseballGameCheckService baseballGameCheckService) {
        this.baseballGameNumberService = baseballGameNumberService;
        this.baseballGameCheckService = baseballGameCheckService;
    }

    public void start(){
        System.out.println("세자리 숫자를 입력해주세요");

        Scanner sc = new Scanner(System.in);
        String number = sc.next();

        System.out.println(number);
    }
}
