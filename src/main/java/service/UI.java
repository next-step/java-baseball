package service;

import domain.*;

import java.util.*;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public String getAnswerByNotice(Notice output) {
        output.print();
        String string = scanner.nextLine();
        if(!answerCondition(string, 3)){
            getAnswerByNotice(output);
        }
        return string;
    }

    public boolean answerCondition(String s, int size){

        HashSet hashSet = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            int value = Character.getNumericValue(c);
            if(!(Character.isDigit(c) || 1 <= value || value <= 9)){
                return false;
            }
            hashSet.add(c);
        }
        if(s.length() != size || hashSet.size() != size)
            return false;
        return true;
    }
}
