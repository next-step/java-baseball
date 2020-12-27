/**
 * StringController.java
 * 2020년 12월 27일 생성
 * 아무 제약 없이 사용할 수 있는 소스코드입니다
 */

import java.util.Arrays;

public class StringController {
    /**
     * 해당 메소드는 index에 해당하는 문자만 잘라낸다
     * ex) chopAt("Test", 1) -> "Tst"
     * @param in        대상 문자열
     * @param index     한 문자를 자를 인덱스
     * @return String: in[index]가 잘려진 문자열
     */
    public static String chopAt(String in, int index) {
        in.charAt(index);      /* index range check */
        if(index == 0) {
            return in.substring(1, in.length());
        }
        if(index == in.length()-1) {
            return in.substring(0, in.length()-1);
        }
        return in.substring(0, index) + in.substring(index+1, in.length());
    }

    public static boolean hasDuplicatedChar(String in){
        if(in.length() < 2) {
            return false;
        }

        char[] chars = in.toCharArray();
        Arrays.sort(chars);
        boolean flag = false;
        for(int i=0; i<chars.length-1; i++){
            flag |= (chars[i] == chars[i+1]);
        }
        return flag;
    }
}
