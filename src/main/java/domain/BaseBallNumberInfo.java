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

    public void setBaseBallPositionNumber(int randomNumber){
        baseBallRandomNumber.add(randomNumber);
    }

    public int getBaseBallPositionNumber(int position){

        return baseBallRandomNumber.get(position);
    }

}
