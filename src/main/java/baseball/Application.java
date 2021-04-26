package baseball;

import static enumType.SystemNumberType.END;

import utils.ValidationUtil;

public class Application {

    public static void main(String[] args) {

        ValidationUtil validationUtil = new ValidationUtil();
        BaseballGame   game           = new BaseballGame();
        
        validationUtil.systemStartingValidation();
        
        boolean isContinue = true;
        
        while (isContinue) {
            game.gameStart();
            isContinue = game.playAgain();
        }
        System.out.println(END.getDescription());
    }
    
}
