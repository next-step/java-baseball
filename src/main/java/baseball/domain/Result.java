package baseball.domain;

import baseball.type.ResultType;

import java.util.ArrayList;

public class Result {

    private ArrayList<Integer> computerList;
    private ArrayList<Integer> userList;

    public Result(ArrayList<Integer> computerList, ArrayList<Integer> userList) {
        this.computerList = computerList;
        this.userList = userList;
    }

    public ResultType getResultType() {
        ResultType resultType = new ResultType();

        for(int i=0; i<userList.size(); i++) {
            add(i, resultType);
        }
        return resultType;
    }

    private boolean add(int index, ResultType resultType) {
        if(isStrike(index)) {
            resultType.strikePlus();
            return true;
        }
        if(isBall(index)) {
            resultType.ballPlus();
            return true;
        }
        return false;
    }

    private boolean isStrike(int index) {
        return computerList.get(index) == userList.get(index);
    }

    private boolean isBall(int index) {
        return computerList.indexOf(userList.get(index)) != -1;
    }
}
