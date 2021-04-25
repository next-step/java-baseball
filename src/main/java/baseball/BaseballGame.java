package baseball;

import utils.RandomNumberUtil;
import utils.ValidationUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

import static enumType.ErrorType.ERROR_1000_INPUT_DATA_TYPE_ERROR;

import static enumType.GameNoticeType.INPUT_REQUEST;

public class BaseballGame {

    RandomNumberUtil randomNumberUtil = new RandomNumberUtil();
    ValidationUtil   validationUtil   = new ValidationUtil();
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 야구 숫자 게임 시작
     * =================================================================== 
     * DATE          AUTHOR         NOTE 
     * ------------------------------------------------------------------- 
     * 2021.04.25    jeeyong.park   컴퓨터 난수 생성 로직 추가
     * 2021.04.25    jeeyong.park   사용자 숫자 입력 및 유효성 체크 로직 추가
     */
    public void gameStart() {
        
        int randomNumber      = 0;
        int playerInputNumber = 0;
        
        // 컴퓨터 난수 생성
        randomNumber = randomNumberUtil.generateRandomNumber();
        
        // 사용자 숫자 입력
        playerInputNumber = playerInput();
        
        // 사용자 입력값 유효성 체크
        validationUtil.playerInputValidation(playerInputNumber);

        System.out.println("randomNumber : "      + randomNumber);
        System.out.println("playerInputNumber : " + playerInputNumber);
        
        //TODO 컴퓨터 난수와 사용자 입력값을 비교하여 심판
        
    }
    
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 사용자에게 값을 입력받는다.
     */
    public int playerInput() {
        
        int playerInputNumber = 0;
        
        System.out.println(INPUT_REQUEST.getMessage());
        
        try {
            Scanner scan = new Scanner(System.in);
            playerInputNumber = scan.nextInt();
            
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException(ERROR_1000_INPUT_DATA_TYPE_ERROR.getErrorMessage());
        }
        
        return playerInputNumber;
    }


}
