package nextstep.baseball.service;

import nextstep.baseball.domain.BaseballEnum;

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
                System.out.println("3개의숫자를모두맞히셨습니다! 게임종료");
                System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");

                if (input().equals("2")) {
                    return;
                }
            }
        }
    }

    public String game(){
        final List<Integer> player2 = baseballGameNumberService.generateComputerNumber();
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            final List<Integer> player1 = baseballGameNumberService.inputUserNumber(input());
            final Map<String, Integer> gameResult = baseballGameCheckService.getGameResult(player1, player2);

            Integer strike = gameResult.get(BaseballEnum.STRIKE.getCode());
            if(strike != null && strike == 3){
                break;
            }
            System.out.println(resultPrint(gameResult));
        }
        return "END";
    }

    private String input(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private String resultPrint(Map<String, Integer> gameResult){
        Integer strike = gameResult.get(BaseballEnum.STRIKE.getCode());
        Integer ball = gameResult.get(BaseballEnum.BALL.getCode());
        String strikeText = strike != null ? strike + " " + BaseballEnum.STRIKE.getName() : "";
        String ballText = ball != null ? ball + " " + BaseballEnum.BALL.getName(): "";

        return (strikeText + " " + ballText).equals(" ") ? BaseballEnum.NOTHING.getName() : (strikeText + " " + ballText);
    }
}
