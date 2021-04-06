public class Operation {
    public int calc(Calc op, int a, int b) {
        switch (op) {
            case SUM: return a + b;
            case SUBTRACT: return a - b;
            case MULTIPLY: return a * b;
            case DIVIDE: return a / b;
            case MOD: return a % b;
            default: throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Operation().calc(Calc.DIVIDE, 10, 3));
        System.out.println(Calc.DIVIDE.apply(10, 3));
        System.out.println(Calc.apply(Calc.MOD, 10, 3));
    }
}
