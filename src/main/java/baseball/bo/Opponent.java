package baseball.bo;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Opponent {

    private String strikeNumber;

    public String getStrikeNumber() {
        return strikeNumber;
    }

    public Opponent() {
        this.resetStrikeNumber();
    }

    public void resetStrikeNumber() {
        this.strikeNumber = this.generateStrikeNumber();
    }

    private String generateStrikeNumber() {

        Set<Integer> numberSet = new LinkedHashSet<>();
        Random random = new Random();
        
        while (true) {

            int i = random.nextInt(9) + 1;
            if(numberSet.contains(i)) {
                continue;
            }

            numberSet.add(i);

            if(numberSet.size()==3) {
                StringBuilder strikeNumber = new StringBuilder();
                for (Integer integer : numberSet) {
                    strikeNumber.append(integer);
                }
                return strikeNumber.toString();
            }
        }
    }
}
