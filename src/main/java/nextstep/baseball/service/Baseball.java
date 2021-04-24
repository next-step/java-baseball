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
            resultPrint(gameResult);
        }
        return END;
    }

    public void message(String str){
        System.out.println(str);
    }

    public String input(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public boolean isOut(Integer strike){
        if(strike != null && strike == 3){
            return true;
        }
        return false;
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

    public void resultPrint(Map<String, Integer> result){
        StringBuffer stringBuffer = new StringBuffer();

        if(result.get(BaseballStatEnum.STRIKE.getCode()) != null){
            stringBuffer.append(result.get(BaseballStatEnum.STRIKE.getCode()));
            stringBuffer.append(BaseballStatEnum.STRIKE.getName());
        }

        if(result.get(BaseballStatEnum.BALL.getCode()) != null){
            stringBuffer.append(result.get(BaseballStatEnum.BALL.getCode()));
            stringBuffer.append(BaseballStatEnum.BALL.getName());
        }

        if(stringBuffer.length() == 0){
            stringBuffer.append(BaseballStatEnum.NOTHING.getName());
        }

        System.out.println(stringBuffer);
    }
}
