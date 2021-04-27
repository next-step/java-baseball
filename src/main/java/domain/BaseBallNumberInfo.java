package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumberInfo {

    private List<Integer> baseBallRandomNumberList;

    public BaseBallNumberInfo(){
        baseBallRandomNumberList = new ArrayList<>();
    }

    public List<Integer> getBaseBallRandomNumberList(){
        return baseBallRandomNumberList;
    }

    public void setBaseBallPositionNumber(int randomNumber){
        baseBallRandomNumberList.add(randomNumber);
    }

    public int getBaseBallPositionNumber(int position){

        return baseBallRandomNumberList.get(position);
    }

}
