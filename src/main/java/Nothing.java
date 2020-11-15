public class Nothing {

    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void print() {
        if (this.count != 0) {
            String name = "포볼";
            System.out.printf("%s", name);
        }
    }

}
