package domain;

public class Strike implements Score {
    private int count;

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void print() {
        if (count > 0) {
            System.out.print(count + " 스트라이크 ");
        }
    }

    @Override
    public void addOneToCount() {
        count++;
    }

    public boolean isWin() {
        return count == 3;
    }

    public int getCount() {
        return count;
    }
}
