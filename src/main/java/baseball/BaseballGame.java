package baseball;


import utils.RandomNumberUtil;

public class BaseballGame {

    RandomNumberUtil randomNumberUtil = new RandomNumberUtil();
    
    /**
     * @author      : jeeyong.park 
     * @date        : 2021.04.25
     * @description : 야구 숫자 게임 시작
     * =================================================================== 
     * DATE          AUTHOR         NOTE 
     * ------------------------------------------------------------------- 
     * 2021.04.25    jeeyong.park   컴퓨터 난수 생성 로직 추가
     */
    public void gameStart() {
        
        int randomNumber = 0;
        
        // 컴퓨터 - 각각 숫자가 겹치지 않는 난수 생성
        randomNumber = randomNumberUtil.generateRandomNumber();
        
        //TODO 사용자 - 입력값 받고, validation 체크까지
        
        //TODO 컴퓨터 난수와 사용자 입력값을 비교하여 심판
        
    }
    
}
