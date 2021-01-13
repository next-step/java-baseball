import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGame {

    private int [] answer;

    public BaseballGame() {
        this.answer = new int[3];

    }
    private void setRandomAnswer() {
        int number;

        for (int i=0; i<3; i++) {
            number = (int) (Math.random()*10+1);
            if (!isAlreadySet(number)) {
                answer[i] = number;
            }
        }
    }
    private boolean isAlreadySet( int n) {
        for(int i=0; i<3; i++) {
            if (answer[i] == n) {
                return true;
            }
        }
        return false;
    }
    public void start() {
        setRandomAnswer();
    }
}
