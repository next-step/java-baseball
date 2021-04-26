package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballValidation {

    public static boolean validInputStr(String string){

        getCheckNull(string);
        getInputLength(string, BaseballConst.ANSWER_SIZE);
        for(int i = 0; i < string.length(); i++){
            getCheckInt(Integer.parseInt(String.valueOf(string.charAt(i))));
        }
        getCheckDiffInt(string);

        return true;
    }

    /*
        널 체크.
     */
    public static boolean getCheckNull(String input){
        if (input != null) {
            return true;
        }
        BaseballUtil.outMessageN(BaseballConst.ANSWER_NULL);
        return false;
    }

    /*
        문자열의 길이 비교 기능
     */
    public static boolean getInputLength(String input, int length){
        if (input.length() == length) {
            return true;
        }
        BaseballUtil.outMessageN(BaseballConst.ANSWER_LENGTH_NOT);
        return false;
    }

    /*
        정수의 크기가 알맞는지 (1 ~ 9)
     */
    public static boolean getCheckInt(int input){
        if (input > 0 && input < 10) {
            return true;
        }
        BaseballUtil.outMessageN(BaseballConst.ANSWER_NUM_SIZE);
        return false;
    }

    /*
        서로 다른 숫자인지 확인.
     */
    public static boolean getCheckDiffInt(String str){
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < chars.length; i++){
            set.add(chars[i]);
        }
        if(set.size() != chars.length){
            BaseballUtil.outMessageN(BaseballConst.ANSWER_DIFF);
            return false;
        }
        return true;
    }

}
