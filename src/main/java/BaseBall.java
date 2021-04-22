import java.util.Random;
import java.util.Scanner;

public class BaseBall {
    static int[] answer;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        init();
        playGame(s);
        s.close();
    }

    private static void playGame(Scanner s) {
        boolean finish = false;
        String input;
        while (!finish) {
            input = s.nextLine();
            finish = check(input);
        }
    }

    private static boolean check(String input) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            judge(input, result, i);
        }
        return result[0] == 3;
    }

    private static void judge(String input, int[] result, int i) {
        int value = Integer.parseInt(String.valueOf(input.charAt(i)));
        if (answer[i] == value) {
            result[0] += 1;
            return;
        }
        if (isContain(value)) {
            result[1] += 1;
        }
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
