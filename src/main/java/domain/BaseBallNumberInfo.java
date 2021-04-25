package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumberInfo {

    private List<Integer> baseBallRandomNumber;

    public BaseBallNumberInfo(){
        baseBallRandomNumber = new ArrayList<>();
    }

    public List<Integer> getBaseBallRandomNumberList(){
        return baseBallRandomNumber;
    }

    public int setBaseBallPositionNumber(int randomNumber){

        baseBallRandomNumber.add(randomNumber);

        return baseBallRandomNumber.size();
    }

    public int getBaseBallPositionNumber(int position){

        return baseBallRandomNumber.get(position);
    }

}
