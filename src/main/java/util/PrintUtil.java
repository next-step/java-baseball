package util;

public class PrintUtil {
    public static final String INFO = "숫자를 입력해주세요 : ";

    public static void printStartInfo() {
        System.out.print(PrintUtil.INFO);
    }

    public static void printStrikeHint(int strikeCnt) {
        System.out.println(strikeCnt + "스트라이크");
    }
}
