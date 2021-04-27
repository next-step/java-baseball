package domain;

public class Nothing implements Score {
    int count;

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void print() {
        if (count == 3) {
            System.out.print("낫싱");
        }
    }

    @Override
    public void addOneToCount() {
        count++;
    }
}
