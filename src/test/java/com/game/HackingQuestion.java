package com.game;

import com.game.baseball.Question;

import java.util.Iterator;
import java.util.Set;

public class HackingQuestion extends Question {

    public Set<Integer> make(int length, Set<Integer> hackingSet) {
        resetData();
        validate(length, hackingSet);

        Iterator<Integer> hackingSetIterator = hackingSet.iterator();
        while (hackingSetIterator.hasNext()) {
            add(hackingSetIterator.next());
        }

        return getData();
    }

    private void validate(int length, Set<Integer> hackingSet) {
        if (length != hackingSet.size()) {
            throw new IllegalArgumentException("문제(Question) 해킹 정보가 올바르지 않습니다.");
        }
    }

}
