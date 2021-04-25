package game.baseball.util.converter;

import java.util.ArrayList;

public class Converter {
    public ArrayList<Integer> convertStringArrayToIntegerList(String[] toBeChanged){
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : toBeChanged) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
