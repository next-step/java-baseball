package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGroup {
    private List<Integer> baseballNumbers = new ArrayList<>();

    private BaseballNumberGroup(List<Integer> baseballNumbers){
        this.baseballNumbers.addAll(baseballNumbers);
    }

    public static BaseballNumberGroup of(List<Integer> baseballNumbers){
        return new BaseballNumberGroup(baseballNumbers);
    }

    public int size(){
        return this.baseballNumbers.size();
    }

    public Integer get(int index){
        return this.baseballNumbers.get(index);
    }

    public boolean contains(Integer baseballNumber){
        return this.baseballNumbers.contains(baseballNumber);
    }

    public int indexOf(Integer baseballNumber){
        return this.baseballNumbers.indexOf(baseballNumber);
    }
}
