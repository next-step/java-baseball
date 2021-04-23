package nextstep.baseball.service;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameNumberServiceImpl implements BaseballGameNumberService {
    List<Integer> randomBox;

    @Override
    public List<Integer> inputUserNumber(String str) {
        List<Integer> result = new ArrayList<>();
        final String[] split = str.split("");

        for(String i : split){
            result.add(Integer.parseInt(i));
        }
        return result;
    }

    @Override
    public void setRandomBox(){
        randomBox = new ArrayList<>();
        for(int i=1;i<10;i++){
            randomBox.add(i);
        }
    }

    @Override
    public List<Integer> generateComputerNumber() {
        setRandomBox();

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<3;i++){
            double randomValue = Math.random();
            int e = (int)(randomValue * randomBox.size()-1);
            result.add(randomBox.remove(e));
        }
        return result;
    }
}
