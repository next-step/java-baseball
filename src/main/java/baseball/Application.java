package baseball;

import static enumType.SystemNumberType.END;

import utils.ValidationUtil;

public class Application {

    public static void main(String[] args) {

        ValidationUtil validationUtil = new ValidationUtil();
        BaseballGame   game           = new BaseballGame();
        
        // 게임시작 전 시스템 셋팅값 유효성 검증
        validationUtil.systemStartingValidation();
        
        boolean isContinue = true;
        
        while (isContinue) {
            // 게임 시작
            game.gameStart();
            
            // 게임 재시작 여부
            isContinue = game.playAgain();
        }
        System.out.println(END.getDescription());
    }
}
