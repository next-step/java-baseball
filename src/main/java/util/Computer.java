package util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Computer {
    String variable;
    static Random random;
    Set<Integer> stringVariable;

    public void initComputerVariable(){
        random = new Random();
        variable = "";
        stringVariable = new HashSet<>();
    }

    public void initComputerValue(){
        initComputerVariable();
        while(stringVariable.size() < 3){
            int addlist  = (int)Math.floor(Math.random() * 10);
            stringVariable.add(addlist);
        }
        for(Integer c : stringVariable){
            variable += Integer.toString(c);
        }
    }

    public String getComputerVariable(){
        return this.variable;
    }
}
