package baseball.domain;

public class Count {
    private int count;

    public Count(){
        count = 0;
    }

    public int getCount(){
        return count;
    }

    public void increase(int increaseCount) {
        count += increaseCount;
    }
}
