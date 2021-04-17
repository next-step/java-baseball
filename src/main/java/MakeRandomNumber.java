import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class MakeRandomNumber {

    public MakeRandomNumber() {

    }

    public int setNumber() {
        int number = 0;
        List<Integer> baseballNumber = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            baseballNumber.add(i);
        }
        Collections.shuffle(baseballNumber);
        number += baseballNumber.get(0)*100;
        number += baseballNumber.get(1)*10;
        number += baseballNumber.get(2);

        return number;
    }

    int newRandomNumber = setNumber();


    public int getNewRandomNumber() {
        return newRandomNumber;
    }
}
