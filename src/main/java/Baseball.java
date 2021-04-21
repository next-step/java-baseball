import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Baseball {

    int SecretNumber = 0;
    int InputUserNumber = 0;

    public void makeSecretNumber() {
        Random rnd = new Random();

        int hundred = (rnd.nextInt(9) + 1) * 100;
        int ten = (rnd.nextInt(9) + 1) * 10;
        int one = rnd.nextInt(9) + 1;

        SecretNumber = hundred + ten + one;
    }

    public void inputUserNumber() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("숫자를 입력해 주세요 : ");
        String stringBuffer = null;
        try {
            stringBuffer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputUserNumber = Integer.parseInt(stringBuffer);
    }
}
