import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseBallGameService {

    public BaseBallNumber createBaseBallNumber() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            Random random = new Random();
            numberSet.add(random.nextInt(9) + 1);
        }
        return new BaseBallNumber(new ArrayList<>(numberSet));
    }

}
