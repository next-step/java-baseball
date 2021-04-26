package view;

import domain.baseball.BaseballGroup;
import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

public class UserInput {

    private static final String INPUT_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String SUCCESS_MATCHING_BASEBALL_NUMBER_MESSAGE = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임종료", BaseballGroup.getRandomLength());
    private static final String SUCCESS_END_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_NOT_MATCHING_NUMBER_MESSAGE = "잘못된 답변을 입력하셨습니다. 재 입력해주세요.";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOT_MATCHING_BALL_COUNT_MESSAGE = "맞은 숫자가 없습니다. 다른 숫자를 기입해보세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private UserInput(){}

    public static String[] baseballMatchingNumberMessage(){
        System.out.println(INPUT_BASEBALL_NUMBER_MESSAGE);
        return charArrayReplaceString(scanner.nextLine().toCharArray());
    }

    private static String baseballMatchingStrikeCount(int strike){
        String resultMessage = "";
        if(strike > 0){
            resultMessage = String.format("%d "+STRIKE_MESSAGE, strike);
        }

        return resultMessage;
    }

    private static String baseballMatchingBallCount(int ball){
        String resultMessage = "";
        if(ball > 0){
            resultMessage = String.format("%d "+BALL_MESSAGE, ball);
        }
        return resultMessage;
    }


    public static String baseballMatchingCount(int strike,int ball){
        String strikeMessage = baseballMatchingStrikeCount(strike);
        String ballMessage = baseballMatchingBallCount(ball);

        if(StringUtils.isEmpty(strikeMessage) && StringUtils.isEmpty(ballMessage)){
            System.out.println(NOT_MATCHING_BALL_COUNT_MESSAGE);
        }

        return strikeMessage + ballMessage;
    }


    public static boolean baseballGameOverAndReStartGame(){
        System.out.println(SUCCESS_MATCHING_BASEBALL_NUMBER_MESSAGE);
        return reStartGameMessage();
    }

    private static boolean reStartGameMessage(){
        boolean checkUserInput = false;

        System.out.println(SUCCESS_END_RESTART_MESSAGE);

        String getUserMessage = scanner.nextLine();
        String[] getUserMessageArray = charArrayReplaceString(getUserMessage.toCharArray());
        if(null != getUserMessageArray && getUserMessageArray.length > 1){
            System.out.println(RESTART_NOT_MATCHING_NUMBER_MESSAGE);
            reStartGameMessage();
        }

        if(getUserMessage.equals("1")){
            checkUserInput = true;
        }

        return checkUserInput;
    }

    private static String[] charArrayReplaceString(char[] inputValue){
        String[] replaceStringNumberValue = new String[inputValue.length];
        for(int i=0; i<inputValue.length; i++){
            replaceStringNumberValue[i] = String.valueOf(inputValue[i]);
        }
        return replaceStringNumberValue;
    }

}
