public class GameOutput {
    private final StringBuilder sb;
    private static final GameOutput instance = new GameOutput();

    private GameOutput() {
        this.sb = new StringBuilder();
    }

    public static GameOutput getInstance() {
        return instance;
    }

    public void writeMessage(String... args) {
        for (String msg : args) {
            sb.append(msg);
            sb.append(" ");
        }
        System.out.println(sb);
        stringBuilderClear();
    }

    public void writeMessageInline(String... args) {
        for (String msg : args) {
            sb.append(msg);
            sb.append(" ");
        }
    }

    public void writeFlush() {
        System.out.println(sb);
        stringBuilderClear();
    }

    private void stringBuilderClear() {
        sb.setLength(0);
    }
}
