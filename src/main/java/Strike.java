public class Strike extends Hint {
    public void print() {
        if (getCount() != 0) {
            String name = "스트라이크";
            System.out.printf("%d%s", getCount(), name);
        }
    }
}
