package baseball;

import utils.NumberUtil;
import utils.ValidationUtil;

import java.util.*;

import static enumType.ErrorType.ERROR_1000_INPUT_DATA_TYPE_ERROR;
import static enumType.GameNoticeType.INPUT_REQUEST;
import static enumType.GameNoticeType.GAME_RESTART_INQUIRE;
import static enumType.SystemNumberType.DIGIT;
import static enumType.SystemNumberType.END;

import static enumType.UmpireType.STRIKE;
import static enumType.UmpireType.BALL;
import static enumType.UmpireType.NOTHING;

public class BaseballGame {

    NumberUtil     numberUtil     = new NumberUtil();
    ValidationUtil validationUtil = new ValidationUtil();
    GameScore      gameScore      = new GameScore();
    
    
    public void gameStart() {
        int randomNumber = generateNumber();
        
        playerTurn(randomNumber);
        gameScore.gameResult();
    }
    
    
    public boolean playAgain() {
        System.out.println(GAME_RESTART_INQUIRE.getMessage());
        int againYn = playerInput();
        
        if (againYn == END.getNumber()) {
            return false;
        }
        
        return true;
    }
    
    
    private int generateNumber() {
        int     randomNumber = 0;
        boolean isRealRandom = false;
        
        do {
            randomNumber = numberUtil.makeRandomNumber();
            isRealRandom = validationUtil.digitValidation(randomNumber, DIGIT.getNumber());
        } while (!isRealRandom);
        
        return randomNumber;
    }
    
    
    private void playerTurn(int randomNumber) {
        int     playerInputNumber = 0;
        boolean isCorrect         = true;
        
        while (isCorrect) {
            System.out.println("\n" + INPUT_REQUEST.getMessage());
            
            playerInputNumber = playerInput();
            validationUtil.playerInputValidation(playerInputNumber);
            
            gameScore = umpire(randomNumber, playerInputNumber);
            printCurrentScore(gameScore);
            
            if (gameScore.getStrikeCnt() >= DIGIT.getNumber()) {
                isCorrect = false;
            }
        }
    }
    
    
    private int playerInput() {
        int playerInputNumber = 0;
        
        try {
            Scanner scan = new Scanner(System.in);
            playerInputNumber = scan.nextInt();
        } catch (InputMismatchException ime) {
            throw new InputMismatchException(ERROR_1000_INPUT_DATA_TYPE_ERROR.getErrorMessage());
        }
        
        return playerInputNumber;
    }
    
    
    private GameScore umpire(int randomNumber, int playerInputNumber) {
        gameScore = new GameScore();
        
        List<Integer> randomNumberList      = Arrays.asList(numberUtil.splitIntegerToArray(randomNumber));
        List<Integer> playerInputNumberList = Arrays.asList(numberUtil.splitIntegerToArray(playerInputNumber));
        
        for (int i = 0; i < randomNumberList.size(); i++) {
            judge(gameScore, randomNumberList.get(i), playerInputNumberList, i);
        }
        
        return gameScore;
    }
    
    
    private void judge(GameScore gameScore, int randomNumber, List comparedList, int index) {
        strikeCount(gameScore, randomNumber, comparedList, index);
        ballCount  (gameScore, randomNumber, comparedList, index);
    }
    
    
    private void strikeCount(GameScore gameScore, int number, List comparedList, int index) {
        int listIndex = comparedList.indexOf(number);
        
        if (listIndex != -1 && listIndex == index) {
            gameScore.strike();
        }
    }
    
    
    private void ballCount(GameScore gameScore, int number, List comparedList, int index) {
        int listIndex = comparedList.indexOf(number);
        
        if (listIndex != -1 && listIndex != index) {
            gameScore.ball();
        }
    }
    
    
    private void printCurrentScore(GameScore gameScore) {
        if (gameScore.getStrikeCnt() != 0) {
            System.out.print(gameScore.getStrikeCnt() + STRIKE.getDecision() + " ");
        }
        if (gameScore.getBallCnt() != 0) {
            System.out.print(gameScore.getBallCnt() + BALL.getDecision() + " ");
        }
        if (gameScore.getStrikeCnt() == 0 && gameScore.getBallCnt() == 0) {
            System.out.print(NOTHING.getDecision());
        }
        System.out.print("\n");
    }
    
    
}
