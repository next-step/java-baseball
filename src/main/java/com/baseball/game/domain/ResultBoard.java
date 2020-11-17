package com.baseball.game.domain;

import com.baseball.game.type.Swing;

import java.util.*;

public class ResultBoard {
    private static final int OUT_COUNT = 3;
    Map<Swing, Integer> swingBoard;

    public ResultBoard(Pitcher pitcher, Batter batter){
        swingBoard = new TreeMap<>();
        verify(pitcher, batter);
        sort();
    }


    public static ResultBoard of(Pitcher pitcher, Batter batter){
        return new ResultBoard(pitcher, batter);
    }

    private void verify(Pitcher pitcher, Batter batter){
        for (int i = 0; i <pitcher.getNumberBox().size() ; i++) {
            Swing key = Swing.findSwingResult(pitcher, batter, i);
            swingBoard.put(key, increaseCount(key));
        }
    }

    private int increaseCount(Swing swing){
        if(swingBoard.containsKey(swing)){
            return swingBoard.get(swing) + 1;
        }

        return 1;
    }


    public void sort() {
        List<Map.Entry<Swing, Integer>> entries = new LinkedList<>(swingBoard.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        LinkedHashMap<Swing, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Swing, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        swingBoard = result;
    }

    public boolean isOut(){
        return swingBoard.get(Swing.STRIKE) != null && swingBoard.get(Swing.STRIKE) == OUT_COUNT;
    }

    @Override
    public String toString() {
        String result = "스윙 결과 : ";
        for(Swing swing : swingBoard.keySet()){
            if(swing != Swing.NOTHING){
                result += String.format("%d%s ", swingBoard.get(swing), swing.getText());
            }
        }

        return result;
    }
}