package service;

import domain.*;

import java.util.*;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public String getAnswerByNotice(Notice output, int size) {
        output.print();
        String string = scanner.nextLine();
        if(!answerCondition(string, size)){
            getAnswerByNotice(output, size);
        }
        return string;
    }

    //todo 영문 캐치 필요
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

    public void printScore(Strike strike, Ball ball, Nothing nothing){
        strike.print();
        ball.print();
        if(strike.getCount() == 0 && ball.getCount() == 0){
            nothing.setCount(Bettings.bettingSize());
            nothing.print();
        }
        System.out.println();
    }
}
