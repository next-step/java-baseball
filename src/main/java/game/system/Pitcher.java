package game.system;

import game.ui.UtilUserInterface;

public class Pitcher {

    public int[] generateDigits(){
        int[] digits = new int[3];

        for(int i = 0; i < digits.length; i++){
            digits[i] = (int) (Math.random() * 9 + 1);

            for(int j = 0; j < i; j++){
                if(digits[j] == digits[i]) {
                    i--;
                    break;
                }
            }
        }
        return digits;
    }

    public int pitch(){
        String message = "숫자를 입력해주세요 : ";
        return UtilUserInterface.viewUI(message);
    }
}
