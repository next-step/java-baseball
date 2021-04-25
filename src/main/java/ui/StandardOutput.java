package ui;

public class StandardOutput implements Output {

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void printLine(String text) {
        System.out.println(text);
    }
}
