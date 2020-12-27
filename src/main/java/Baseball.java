/**
 * Baseball.java
 * 2020년 12월 26일 생성
 * 아무 제약 없이 사용할 수 있는 소스코드입니다
 */
public class Baseball {
    final private static int INPUT_LENGTH = 3;

    public static int countBalls(String a, String b){
        int balls = 0;
        for(int i=0; i<INPUT_LENGTH; i++){
            String s = StringController.chopAt(b, i);
            balls += (s.indexOf(a.charAt(i)) >= 0) ? 1: 0;
        }
        return balls;
    }

    public static int countStrikes(String a, String b) {
        int strikes = 0;
        for(int i=0; i<INPUT_LENGTH; i++){
            strikes += (a.charAt(i) == b.charAt(i)) ? 1 : 0;
        }
        return strikes;
    }

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
