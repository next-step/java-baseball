public class Ball extends Hint {
    public void print() {
        if (getCount() != 0) {
            String name = "볼";
            System.out.printf("%d%s", getCount(), name);
        }
    }
}
