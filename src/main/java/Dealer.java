import java.util.HashSet;
import java.util.Random;

public class Dealer {
    private int[] numList;

    private HashSet<Integer> generateRandomNumbers() {
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<>();

        while (hashSet.size() < 3) {
            hashSet.add(random.nextInt(9) + 1);
        }

        return hashSet;
    }

    private int[] pickNumbers() {
        int [] pickedNumbers = new int[3];
        HashSet<Integer> pickedSet = generateRandomNumbers();
        int i = 0;

        for (Integer num : pickedSet) {
            pickedNumbers[i++] = num;
        }

        return pickedNumbers;
    }

    public int[] getList() {
        return numList;
    }

    public Dealer() {
        numList = pickNumbers();

        while (!Rule.isValid(numList)) {
            numList = pickNumbers();
        }
    }
}
