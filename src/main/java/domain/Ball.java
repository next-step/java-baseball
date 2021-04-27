package domain;

public class Ball implements Score{
    private int count;

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void print() {
        if (count > 0) {
            System.out.print(count + " 볼");
        }
    }

    @Override
    public void addOneToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
