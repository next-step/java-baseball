import java.util.Random;

public class Baseball {

    int SecretNumber = 0;

    public void makeSecretNumber() {
        Random rnd = new Random();

        int hundred = (rnd.nextInt(9) + 1) * 100;
        int ten = (rnd.nextInt(9) + 1) * 10;
        int one = rnd.nextInt(9) + 1;

        SecretNumber = hundred + ten + one;
    }
}
