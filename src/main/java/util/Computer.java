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


}
