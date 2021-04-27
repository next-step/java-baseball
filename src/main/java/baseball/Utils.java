package baseball;

public class Utils {
    // 생성자 사용하지 못하도록.
    private Utils() {}

    /**
     * boolean 값이 true이면 1을 false 이면 0을 반환한다.
     * @param data 입력 데이터.
     * @return true이면 1을 false 이면 0
     */
    public static int booleanToInt(boolean data) {
        return data ? 1 : 0;
    } 
}
