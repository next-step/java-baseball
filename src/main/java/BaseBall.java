import java.util.Arrays;
import java.util.Random;

public class BaseBall {
    static int [] answer;

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        answer = new int[3];
        Random random = new Random(System.currentTimeMillis());
        int index = 0;
        while (index < 3) {
            index = fillNum(random, index);
        }
    }

    private static int fillNum(Random random, int index) {
        int value = random.nextInt(9) + 1;
        if (!isContain(value)) {
            answer[index] = value;
            return index + 1;
        }
        return index;
    }

    private static boolean isContain(int value) {
        return answer[0] == value || answer[1] == value || answer[2] == value;
    }
}
