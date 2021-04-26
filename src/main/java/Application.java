import baseball.Baseball;
import baseball.GameCore;

public class Application {

    public static void main(String[] args) {

        boolean flag = true;
        while (flag || GameCore.processor()){
            flag = false;

            Baseball baseball = new Baseball();
            baseball.doStart();

        }

    }
}
