package com.sang5c.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baseball {

    private final List<String> numbers;

    public Baseball(String s) {
        String[] split = s.split("");
        List<String> numbers = new ArrayList<>(Arrays.asList(split));

        this.numbers = numbers;
    }

}
