package woowahan.study;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class BaseBall {

  /**
   * 랜덤텍스트 생성
   * : 상대방(컴퓨터) 수 생성
   */
  public String[] getRandomText() {
    Random fixRandomCount = new Random();
    Set<String> randomDataSet = new HashSet<>();
    do {
      String randomInt = Integer.toString(fixRandomCount.nextInt(10));
      randomDataSet.add(randomInt);
    } while (randomDataSet.size() < 3);
    String[] randomText = new String[randomDataSet.size()];
    randomDataSet.toArray(randomText);
    return randomText;
  }

}
