package com.baseball.precourse.util;

import com.baseball.precourse.baseball.Ball;

import java.util.LinkedHashSet;
import java.util.Set;

public class DigitString {

    private String digit;

    public DigitString(String digit){
        this.digit = digit;
        validate();
    }

    private void validate() {
        try {
            Integer.parseInt(digit);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자가 아닌 값이 존재합니다");
        }
    }

    private char getDigit(int pos){
        return digit.charAt(pos);
    }

    public int matchPosCount(DigitString inputNumber) {
        int count = 0;
        for (int pos = 0; pos < digit.length(); pos++) {
            count += matchDigitHelper(this.getDigit(pos), inputNumber.getDigit(pos));
        }
        return count;
    }

    public int matchCount(DigitString inputNumber) {
        int count = 0;
        String uniqueNumber = inputNumber.unique();
        for (int pos = 0; pos < uniqueNumber.length(); pos++) {
            count += includeDigitHelper(digit, uniqueNumber.charAt(pos));
        }
        return count;
    }

    public String unique(){
        Set<String> unique = new LinkedHashSet<>();
        for(Character c :digit.toCharArray()) {
            unique.add(c.toString());
        }
        return String.join("", unique);
    }

    private static int matchDigitHelper(char first, char second){
        if (first == second){
            return 1;
        }
        return 0;
    }

    public static int includeDigitHelper(String org, char first){
        if (org.indexOf(first) >= 0){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return digit;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        DigitString other = (DigitString) obj;
        if (other.digit == digit){
            return true;
        }
        return false;
    }
}
