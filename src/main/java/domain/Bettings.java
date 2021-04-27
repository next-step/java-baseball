package domain;

import java.util.ArrayList;
import java.util.List;

public class Bettings {
    private static final int bettingSize = 3;
    private char[] userInputs;
    private List<Integer> computerValues;

    public Bettings(List<Integer> computerValues) {
        this.computerValues = computerValues;
    }

    public Bettings(char[] userInputs, List<Integer> computerValues) {
        this.userInputs = userInputs;
        this.computerValues = computerValues;
    }

    public static int bettingSize() {
        return bettingSize;
    }

    public char[] getUserInputs() {
        return userInputs;
    }

    public void setUserInputs(char[] userInputs) {
        this.userInputs = userInputs;
    }

    public List<Integer> getComputerValues() {
        return computerValues;
    }

    public void setComputerValues(ArrayList<Integer> computerValues) {
        this.computerValues = computerValues;
    }
}
