package com.zenic88.baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

  public List<Integer> generate() {
    List<Integer> numberList = getRandomNumberList();
    while (numberList.size() > 3) {
      numberList.remove(0);
    }
    return numberList;
  }

  private List<Integer> getRandomNumberList() {
    List<Integer> randomNumberList = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      randomNumberList.add(i);
    }
    Collections.shuffle(randomNumberList);
    return randomNumberList;
  }
}
