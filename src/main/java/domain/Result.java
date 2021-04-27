package domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final int CLEAR_POINT = 3;
    private Map<State, Count> result;

    public Result() {
        this.result = new HashMap<>();
        init();
    }

    private void init() {
        for(State state : State.values()){
            result.put(state, new Count());
        }
    }

    public void stateCountPlus(State state){
        result.get(state).plus();
    }

    public boolean isGameClear(){
        return result.get(State.STRIKE).equals(new Count(CLEAR_POINT));
    }
    @Override
    public String toString() {
        String strike = result.get(State.STRIKE).isNotEmpty() ? result.get(State.STRIKE).getCount() + " "+State.STRIKE.getKor():"" ;
        String boll = result.get(State.BOLL).isNotEmpty() ? result.get(State.BOLL).getCount() + " "+State.BOLL.getKor():"" ;

        String result = strike + boll;

        return !result.isEmpty() ? result : "일치한 번호가 없습니다" ;
    }

    public void resetCount() {
        for(State state : result.keySet()){
            result.get(state).reset();
        }
    }

    public Count stateCount(State state) {
        return result.get(state);
    }
}
