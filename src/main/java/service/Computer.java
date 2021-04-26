package service;

import domain.Bettings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    public List<Integer> makeValuesBySize(int size) {
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            range.add(i);
        }
        Collections.shuffle(range);
        return range.subList(0,size);
    }

    public Bettings setComputerValues(){
        int size = Bettings.bettingSize();
        List<Integer> computerValues = makeValuesBySize(size);
        return new Bettings(computerValues);
    }
}
