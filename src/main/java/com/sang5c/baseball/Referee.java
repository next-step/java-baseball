package com.sang5c.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Referee {

    public static CountDto compare(Set<String> question, Set<String> userNumbers) {
        CountDto countDto = new CountDto();

        List<String> questionStrings = new ArrayList<>(question);
        List<String> userStrings = new ArrayList<>(userNumbers);
        for (int i = 0; i < userStrings.size(); i++) {
            if (questionStrings.contains(userStrings.get(i))) {
                if (questionStrings.get(i).equals(userStrings.get(i))) {
                    countDto.increaseStrikeCount();
                    continue;
                }
                countDto.increaseBallCount();
            }
        }

        return countDto;
    }
}
