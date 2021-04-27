package com.vjerksen;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public boolean chkLength(String stringNum) {
        if (stringNum.length() != 3) {
            return false;
        }

        return true;
    }

    public boolean chkDuplication(String stringNum) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < stringNum.length(); i++) {
            set.add(stringNum.charAt(i));
        }

        if (set.size() != stringNum.length()) {
            return false;
        }

        return true;
    }
}
