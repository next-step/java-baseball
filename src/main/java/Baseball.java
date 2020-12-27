/**
 * Baseball.java
 * 2020년 12월 26일 생성
 * 아무 제약 없이 사용할 수 있는 소스코드입니다
 */
public class Baseball {
    final private static int INPUT_LENGTH = 3;

    public static boolean isValidInput(String in) {
        if(!in.matches("^[0-9]+$")) {
            return false;
        }
        if(in.length() != Baseball.INPUT_LENGTH) {
            return false;
        }
        return true;
    }
}
