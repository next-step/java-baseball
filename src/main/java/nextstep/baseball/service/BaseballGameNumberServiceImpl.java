package nextstep.baseball.service;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameNumberServiceImpl implements BaseballGameNumberService {
    @Override
    public List<Integer> inputUserNumber(String str) {
        List<Integer> result = new ArrayList<>();
        final String[] split = str.split("");

        for(String i : split){
            try {
                result.add(Integer.parseInt(i));
            }catch (java.lang.NumberFormatException e){
                System.out.println("세자리 숫자를 초과했습니다. 뒷자리는 무효처리됩니다.");
                break;
            }
        }
        return result;
    }

    @Override
    public List<Integer> getRandomBox(){
        List<Integer> randomBox = new ArrayList<>();
        for(int i=1;i<10;i++){
            randomBox.add(i);
        }
        return randomBox;
    }

    @Override
    public List<Integer> generateComputerNumber() {
        List<Integer> randomBox = getRandomBox();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<3;i++){
            double randomValue = Math.random();
            int e = (int)(randomValue * randomBox.size()-1);
            result.add(randomBox.remove(e));
        }
        return result;
    }
}
