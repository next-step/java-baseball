public class Number {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
