import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {
    public int[] getBaseballNumber(){
        int[] baseballNumber = new int[3];
        Set<Integer> randomNumber = new HashSet<>();
        while(randomNumber.size() < 3){
            randomNumber.add((int)(Math.random() * 9 + 1));
        }

        int i = 0;
        for (int r: randomNumber) {
            baseballNumber[i++] = r;
        }

        return baseballNumber;
    }
}
