import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {
    public Set<Integer> getBaseballNumber(){
        Set<Integer> baseballNumber = new HashSet<>();
        while(baseballNumber.size() < 3){
            baseballNumber.add((int)(Math.random() * 9 + 1));
        }
        return baseballNumber;
    }
}
