import game.Baseball;

public class Application {

    public static void main(String[] args) {
        try {
            Baseball baseball = new Baseball();
            baseball.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
