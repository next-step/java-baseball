import java.util.Random;

public class BaseBallGame {
    private int cnt;

    public void main(String[] args) throws Exception {
        int[] answer = new int[cnt];
        int status = 1; //1 : (재)시작, 2 : 종료
        setNumber();
    }

    public int[] setNumber() {
        int[] answer = new int[cnt];
        Random random = new Random();
        while (true) {
            answer[0] = random.nextInt(10);
            answer[1] = random.nextInt(10);
            answer[2] = random.nextInt(10);
            if (answer[0] != answer[1] && answer[0] != answer[2] && answer[1] != answer[2]) break;
        }
        return answer;
    }


}
