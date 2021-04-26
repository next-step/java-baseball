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
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 야구 숫자 게임 시작
     * =================================================================== 
     * DATE          AUTHOR         NOTE 
     * ------------------------------------------------------------------- 
     * 2021.04.25    jeeyong.park   컴퓨터 난수 생성 로직 추가
     * 2021.04.25    jeeyong.park   사용자 숫자 입력 및 유효성 체크 로직 추가
     * 2021.04.26    jeeyong.park   컴퓨터 난수와 사용자 입력값을 비교하여 심판하는 로직 추가
     * 2021.04.26    jeeyong.park   점수 출력 로직 추가
     */
    public void gameStart() {
        
        // 컴퓨터 난수 생성
        int randomNumber = generateNumber();
    
        // 사용자 게임 진행
        playerTurn(randomNumber);
        
        // 게임 결과 출력
        gameScore.gameResult();
        
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : 게임 재시작 여부를 결정한다.
     */
    public boolean playAgain() {
        System.out.println(GAME_RESTART_INQUIRE.getMessage());
        
        int againYn = playerInput();
        
        if (againYn == END.getNumber()) {
            return false;
        }
        
        return true;
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : 3자리의 중복되지 않은 난수를 생성한다.
     */
    private int generateNumber() {
        
        int     randomNumber = 0;
        boolean isRealRandom = false;
        
        do {
            randomNumber = numberUtil.makeRandomNumber();
            isRealRandom = validationUtil.digitValidation(randomNumber, DIGIT.getNumber());
        } while (!isRealRandom);
        
        return randomNumber;
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : 사용자로부터 숫자를 입력받고, 유효성 체크하고, 결과를 확인한다. 
     */
    private void playerTurn(int randomNumber) {
        
        int     playerInputNumber = 0;
        boolean isCorrect         = true;
        
        while (isCorrect) {
            System.out.println("\n" + INPUT_REQUEST.getMessage());
            
            // 사용자 숫자 입력
            playerInputNumber = playerInput();
            
            // 사용자 입력값 유효성 체크
            validationUtil.playerInputValidation(playerInputNumber);
            
            gameScore = umpire(randomNumber, playerInputNumber);
            
            printCurrentScore(gameScore);
            
            if (gameScore.getStrikeCnt() >= DIGIT.getNumber()) {
                isCorrect = false;
            }
        }
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 사용자에게 값을 입력받는다.
     */
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
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : 컴퓨터 생성 난수와 사용자 입력값을 비교하여 결과를 판정한다.
     */
    private GameScore umpire(int randomNumber, int playerInputNumber) {
        
        GameScore gameScore = new GameScore();
        
        List<Integer> randomNumberList      = Arrays.asList(numberUtil.splitIntegerToArray(randomNumber));
        List<Integer> playerInputNumberList = Arrays.asList(numberUtil.splitIntegerToArray(playerInputNumber));
        
        for (int i = 0; i < randomNumberList.size(); i++) {
            judge(gameScore, randomNumberList.get(i), playerInputNumberList, i);
        }
        
        return gameScore;
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : 난수와 입력받은 수를 판정한다.
     */
    private void judge(GameScore gameScore, int randomNumber, List comparedList, int index) {
        strikeCount(gameScore, randomNumber, comparedList, index);
        ballCount  (gameScore, randomNumber, comparedList, index);
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : Strike 판정한다. 
     */
    private void strikeCount(GameScore gameScore, int number, List comparedList, int index) {
        int listIndex = comparedList.indexOf(number);
        if (listIndex != -1 && listIndex == index) {
            gameScore.strike();
        }
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : Ball 판정한다. 
     */
    private void ballCount(GameScore gameScore, int number, List comparedList, int index) {
        int listIndex = comparedList.indexOf(number);
        if (listIndex != -1 && listIndex != index) {
            gameScore.ball();
        }
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.26
     * @description : 현재 점수를 출력한다.
     */
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
