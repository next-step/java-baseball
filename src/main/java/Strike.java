public class Strike {

    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void print() {
        if (this.count != 0) {
            String name = "스트라이크";
            System.out.printf("%d%s", this.count, name);
        }
    }

}
