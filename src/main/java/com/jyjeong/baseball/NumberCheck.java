package com.jyjeong.baseball;

public class NumberCheck {

    /**
     * param으로 받아온 int array 의 중복여부 return
     * @return true / false
     */
    public boolean uniqueCheck(int[] num){
        return (num[0] != num[1]) && (num[0] != num[2]) && (num[1] != num[2]);
    }

    /**
     * 숫자 여부 체크
     * @return true / false
     */
    public boolean numberCheck(String num){
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * 숫자의 범위 체크
     * @return true / false
     */
    public boolean lengthCheck(String num){
        return num.length() > 0 && num.length() < 4;
    }

}
