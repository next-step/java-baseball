public class Nothing extends Hint {
    public void print() {
        if (getCount() != 0) {
            String name = "포볼";
            System.out.printf("%s", name);
        }
    }
}
