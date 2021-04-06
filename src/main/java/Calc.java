import java.util.function.BiFunction;

public enum Calc {
    SUM((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> a / b),
    MOD((a, b) -> a % b);

    private final BiFunction<Integer, Integer, Integer> biFunction;

    Calc(BiFunction<Integer, Integer, Integer> biFunction) {
        this.biFunction = biFunction;
    }

    public int apply(int a, int b) {
        return biFunction.apply(Integer.valueOf(a), Integer.valueOf(b));
    }

    public static int apply(Calc op, int a, int b) {
        return op.apply(a, b);
    }
}