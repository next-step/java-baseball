package baseball;

import utils.ValidationUtil;

public class Application {

    public static void main(String[] args) {

        ValidationUtil validationUtil = new ValidationUtil();
        BaseballGame   game           = new BaseballGame();
        
        // 게임시작 전 시스템 셋팅값 유효성 검증
        validationUtil.systemStartingValidation();
        
        // TODO 게임 시작/종료값 상수 선언 후 '게임 종료' 입력 전까지 아래 로직 반복하도록 구현
        
        // 게임 시작
        game.gameStart();
        
    }

}
