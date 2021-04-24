package baseball;

public class NumValidChecker {

    public void isNumber(String input) {
        int len = input.length();
        boolean isNum = true;
        for(int i=0; i<len; ++i) {
            int num = input.charAt(i) - '0';
            isNum = checkNumInRange(isNum,num);
        }

        if(!isNum) throw new IllegalArgumentException("올바른 숫자만 입력해 주세요.");
    }
    private boolean checkNumInRange(boolean isNumber, int num) {
        if(!(0 <= num && num < 10)) isNumber = false;
        return isNumber;
    }

    public void isThreesize(String input) {
        if(input.length() != 3) throw new IllegalArgumentException("세자리 숫자만 입력해 주세요.");
    }
}
