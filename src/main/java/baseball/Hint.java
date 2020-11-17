package baseball;

/**
 * 힌트 클래스
 */
public class Hint {

    private int count = 0;  // 힌트 카운트
    public int getCount() { return count; }

    /**
     * 힌트 카운트 증가
     */
    public void add() {
        count++;
    }
}