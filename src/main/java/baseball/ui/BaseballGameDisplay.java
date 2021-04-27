package baseball.ui;

public final class BaseballGameDisplay {
    public static final String NEW_LINE = "\n";

    public static void display(Object o){
        display(o.toString());
    }

    public static void display(String msg){
        System.out.println(msg);
    }

    public static void newLine(){
        newLine(1);
    }

    public static void newLine(int newLineCount){
        for (int i = 0; i < newLineCount; i++) {
            System.out.println(NEW_LINE);
        }
    }
}
