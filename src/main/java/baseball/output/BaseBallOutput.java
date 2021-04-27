package baseball.output;

public abstract class BaseBallOutput<T> {
    protected StringBuffer stringBuffer = new StringBuffer();

    abstract public void print(T t);
    abstract public void printText(String... lines);

    public String flush() {
        String output = stringBuffer.toString();
        stringBuffer.setLength(0);
        return output;
    }
}
