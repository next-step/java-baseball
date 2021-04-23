package nextstep.baseball.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BaseballGame {
    private final BaseballGameNumberService baseballGameNumberService;
    private final BaseballGameCheckService baseballGameCheckService;

    public BaseballGame(BaseballGameNumberService baseballGameNumberService, BaseballGameCheckService baseballGameCheckService) {
        this.baseballGameNumberService = baseballGameNumberService;
        this.baseballGameCheckService = baseballGameCheckService;
    }

    public void start(){
        while(true) {
            if (game().equals("END")) {
                System.out.println("더할래?");
                if (input().equals("y")) {
                    game();
                }
                return;
            }
        }
    }

    public String game(){
        final List<Integer> player2 = baseballGameNumberService.generateComputerNumber();
        while(true) {
            System.out.println("세자리 숫자를 입력해주세요");
            final List<Integer> player1 = baseballGameNumberService.inputUserNumber(input());
            final Map<String, Integer> gameResult = baseballGameCheckService.getGameResult(player1, player2);

            if(gameResult.get("strike") != null && gameResult.get("strike") == 3){
                break;
            }
            System.out.println(player2);
            System.out.println(gameResult);
        }
        return "END";
    }

    private String input(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
