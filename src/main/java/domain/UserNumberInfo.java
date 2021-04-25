package domain;

import java.util.ArrayList;
import java.util.List;

public class UserNumberInfo {

    private List<Integer> userInputNumberList;

    public UserNumberInfo(){
        userInputNumberList = new ArrayList<>();
    }

    public List<Integer> getUserInputNumberList(){
        return userInputNumberList;
    }

    public void setUserInputNumber(int number){

        userInputNumberList.add(number);
    }

    public int getUserPositionNumber(int position){
        return userInputNumberList.get(position);
    }


}
