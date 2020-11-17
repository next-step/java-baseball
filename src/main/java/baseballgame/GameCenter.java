package baseballgame;

import baseballgame.component.AnswerGenerator;
import baseballgame.component.InputValidator;
import baseballgame.component.MessagePrinter;
import baseballgame.component.ResultChecker;
import baseballgame.domain.Result;

import java.util.List;
import java.util.Scanner;

public class GameCenter {

    private final Scanner scanner = new Scanner(System.in);
    private List<Integer> answer;

    /**
     * 게임 시작
     */
    public void startGame(){
        prepareGame();
        playGame();
    }

    /**
     * 게임 진행 전 준비
     */
    private void prepareGame(){
        answer = AnswerGenerator.generate();
    }

    /**
     * 게임 진행
     */
    private void playGame(){
        Result result = null;
        do {
            result = gameProcess(result);
        } while(result.isClear() == false);
        clearGame();
    }

    private Result gameProcess(Result result){
        MessagePrinter.requestInputMessage();
        String inputString = scanner.next();
        try{
            List<Integer> input = InputValidator.validate(inputString);
            result = ResultChecker.getInstance().check(input, answer);
            MessagePrinter.printResult(result);
        }catch(IllegalArgumentException e){
            MessagePrinter.printInvalidInput();
            return new Result();
        }
        return result;
    }

    /**
     * 게임 클리어 후 동작
     */
    private void clearGame(){
        MessagePrinter.restartMessage();
        String inputString = scanner.next();
        if (inputString.equals("1")) {
            startGame();
        }
    }

}
