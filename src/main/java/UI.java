import java.util.Scanner;
import java.util.regex.Pattern;

final class UI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern PATTERN = Pattern.compile("[1-9]{3}");

    private UI() {}

    static void println(String speak) {
        System.out.println(speak);
    }

    static void print(String speak) {
        System.out.print(speak);
    }

    static void printNumber(int[] num) {
        println(String.format("%d %d %d", num[0], num[1], num[2]));
    }

    static boolean again(boolean needExit) {
        if (needExit) {
            return false;
        }
        print("한 번 더 하시겠습니까?[y/n]:");
        final String needAgain = scanner.next().trim();
        return "y".equalsIgnoreCase(needAgain);
    }

    static int[] enterNumber() {
        print("숫자를 입력해주세요[q:quit]:");
        final String input = scanner.next().trim();
        if (needExit(input)) {
            return null;
        }
        if (validate(input)) {
            return new int[] {
                    Integer.parseInt(input.substring(0, 1)),
                    Integer.parseInt(input.substring(1, 2)),
                    Integer.parseInt(input.substring(2, 3)),
                    };
        }
        println("잘못된 입력입니다.");
        return enterNumber();
    }

    private static boolean needExit(String input) {
        return "q".equalsIgnoreCase(input);
    }

    static boolean validate(String input) {
        return PATTERN.matcher(input).matches() &&
               input.charAt(0) != input.charAt(1) &&
               input.charAt(0) != input.charAt(2) &&
               input.charAt(1) != input.charAt(2);
    }
}
