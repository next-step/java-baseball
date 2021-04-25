import java.util.Random;

public class Dealer {
    private int[] numList;

    private void pickNumbers() {
        numList = new int[3];
        Random random = new Random();
        numList[0] = random.nextInt(9) + 1;

        numList[1] = random.nextInt(9) + 1;

        while (numList[1] == numList[0]) {
            numList[1] = random.nextInt(9) + 1;
        }

        numList[2] = random.nextInt(9) + 1;

        while ((numList[2] == numList[0]) || (numList[2] == numList[1])) {
            numList[2] = random.nextInt(9) + 1;
        }
    }

    public int[] getList() {
        return numList;
    }

    public Dealer() {
        pickNumbers();
    }
}
