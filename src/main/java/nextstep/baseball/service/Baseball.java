package nextstep.baseball.service;

import nextstep.baseball.domain.BaseballStatEnum;
import nextstep.baseball.domain.BaseballMessageEnum;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Baseball {
    final static String END = "END";
    final static String CONTINUE = "1";
    final static String STOP = "2";

    private final BaseballGameNumberService baseballGameNumberService;
    private final BaseballGameCheckService baseballGameCheckService;

    public Baseball(BaseballGameNumberService baseballGameNumberService, BaseballGameCheckService baseballGameCheckService) {
        this.baseballGameNumberService = baseballGameNumberService;
        this.baseballGameCheckService = baseballGameCheckService;
    }

    public void run(){
        if (start().equals(END)) {
            message(BaseballMessageEnum.E1.getMessage());
            message(BaseballMessageEnum.Q2.getMessage());
            reStart(input());
        }
    }

    public String start(){
        final List<Integer> player2 = baseballGameNumberService.generateComputerNumber();
        while(true) {
            message(BaseballMessageEnum.Q1.getMessage());
            final List<Integer> player1 = baseballGameNumberService.inputUserNumber(input());
            final Map<String, Integer> gameResult = baseballGameCheckService.getGameResult(player1, player2);

            if(isOut(gameResult.get(BaseballStatEnum.STRIKE.getCode()))){
                break;
            }
            System.out.println(baseballGameCheckService.resultPrint(gameResult));
        }
        return END;
    }

    public boolean isOut(Integer strike){
        if(strike != null && strike == 3){
            return true;
        }
        return false;
    }

    public String input(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public void message(String str){
        System.out.println(str);
    }

    private void reStart(String flag){
        if(flag.equals(CONTINUE)){
            run();
            return;
        }

        if(flag.equals(STOP)){
            return;
        }
    }
}
