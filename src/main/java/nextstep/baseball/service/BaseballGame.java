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
        final String gameResult = game(baseballGameNumberService.generateComputerNumber());
        while(true) {
            if (gameResult.equals("END")) {
                System.out.println("더할래?");
                if (input().equals("y")) {
                    game(baseballGameNumberService.generateComputerNumber());
                }
                return;
            }
        }
    }

    public String game(List<Integer> player2){
        boolean status = true;
        while(status) {
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
