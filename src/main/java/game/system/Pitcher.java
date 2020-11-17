package game.system;

import game.ui.UtilUserInterface;

public class Pitcher {

    public int generateKey(){
        return  123;
    }

    public int pitch(){
        String message = "숫자를 입력해주세요 : ";
        return UtilUserInterface.viewUI(message);
    }
}
