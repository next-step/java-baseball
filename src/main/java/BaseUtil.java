import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseUtil {

    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumber;
        Random random = new Random();
        random.setSeed(System.nanoTime());
        int min = 1, max = 9;
        Set<Integer> setNumber = new HashSet<>();
        while (setNumber.size() != 3) {
            setNumber.add(random.nextInt(max - min + 1) + min);
        }
        randomNumber = new ArrayList<>(setNumber);
        Collections.shuffle(randomNumber); // Set이 무작위로 보여도 Hashcode의 순으로 넣어 정렬된 경우가 많아서 다시 섞는다.
        return randomNumber;
    }

}