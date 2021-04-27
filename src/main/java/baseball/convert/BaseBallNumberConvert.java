package baseball.convert;

public class BaseBallNumberConvert implements BaseBallConvert {
    @Override
    public int[] convert(int value) {
        int length = (int) (Math.log10(value) + 1);
        int[] newNumber = new int[length];
        int step = 0;

        while(value != 0) {
            newNumber[length-1-step] = value % 10;
            value = value / 10;
            step++;
        }

        return newNumber;
    }
}
