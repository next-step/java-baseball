package service;

import domain.*;
import java.util.*;
import static utils.ValidCheck.*;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public String getAnswerByNotice(Notice output, int size) {
        String string;
        do {
        output.print();
        string = scanner.nextLine();
        } while(!validAnswer(string, size));
        return string;
    }

    public boolean validAnswer(String s, int size){
        return isNumeric(s) && validLength(s, size) && !hasDuplicate(s);
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
