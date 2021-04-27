package baseball.service;

import baseball.domain.*;


public class GameService {

    public void start(){
        Boolean runFlag = true;

        while(runFlag){
            newGame();
        }

    };

    public void newGame(){
        UserNumber userNumber = new UserNumber();
        userNumber.UserNumber();
        System.out.println(userNumber);
    }
}
