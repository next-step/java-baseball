package com.github.esjo.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import com.github.esjo.NumberComparator;
import com.github.esjo.NumberGenerator;

public class Computer {

    private static Set<Integer> numberSet;
    private static Computer computer;

    private Computer() {
    }

    /**Computer객체 초기화 정적 메서드
     * @param numberGenerator 야구게임을 위한 numberSet을 만들기 위한 클래스
     * @return Computer 객체 생성
     * */
    public static Computer createNumberSet(NumberGenerator numberGenerator) {
        computer = new Computer(); // private Constructor
        Set<Integer> set = new LinkedHashSet<>(); // LinkedHashSet : 순서를 가지고 중복을 허용하지 않음.
        while (set.size() < Rule.NUMBER_OF_DIGITS.getValue()) {
            int number = numberGenerator.generateRandomNumber();
            set.add(number);
        }
        computer.setNumberSet(set);
        return computer;
    }

    /**
     * Computer객체와 Player객체의 numberSet비교
     * @param player Player객체 = 게임플레이어
     * */
    public void matchWith(Player player) {
        NumberComparator numberComparator = new NumberComparator(); // numberSet 비교를 위한 클래스
        Status statusOfPlayer = numberComparator.compareAwithB(computer.getNumberSet(), player.getNumberSet());
        player.setStatus(statusOfPlayer);
    }

    /** getter for numberSet */
    public Set<Integer> getNumberSet() {
        return numberSet;
    }

    /** setter for numberSet */
    public void setNumberSet(Set<Integer> numberSet) {
        this.numberSet = numberSet;
    }

}

