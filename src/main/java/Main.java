public class Main {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.makeSecretNumber();

        while (true) {
            baseball.inputUserNumber();
            if (baseball.compare() && baseball.gameShutdown()) {
                break;
            }
        }
    }
}
