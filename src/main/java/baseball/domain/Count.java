package baseball.domain;

public class Count {
    public static final int ZERO = 0;
    private int count;

    public Count(){
        count = ZERO;
    }

    public int getCount(){
        return count;
    }

    public void increase(int increaseCount) {
        if(increaseCount < ZERO){
            throw new IllegalArgumentException("값 증가에 음수는 허용되지 않습니다.");
        }
        count += increaseCount;
    }
}
