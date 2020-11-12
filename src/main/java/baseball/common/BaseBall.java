package baseball.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class BaseBall {

  private static final int MAX_NUMBER = 9;

  private static final int ZERO_NUMBER_EXCEPT = 1;

  private static final int COLLECTION_NUMBER_SIZE = 3;

  private final HashSet<Integer> baseBalls;

  public BaseBall() {
    this.baseBalls = createRandomBaseBalls();
  }

  public BaseBall(HashSet<Integer> baseBalls) {
    this.baseBalls = baseBalls;
  }

  /**
   * 생성 된 랜덤 3개의 숫자(볼) 및 숫자 가져오기
   * @return 중복 없는 랜덤 3개의 숫자 HashSet
   */
  HashSet<Integer> getBaseBalls() {
    return this.baseBalls;
  }

  /**
   * 현재 저장 된 랜덤 3개의 숫자(볼) 최소값 및 최대값 체크
   * @param baseBalls 등록 된 랜덤 3개의 숮자 HashSet
   */
  void validateRandomNumberMax(HashSet<Integer> baseBalls) {
    int minNumber = Collections.min(baseBalls);
    int maxNumber = Collections.max(baseBalls);

    if (minNumber == 0 || maxNumber >= MAX_NUMBER + ZERO_NUMBER_EXCEPT) {
      throw new IllegalArgumentException("랜덤으로 나온 숫자가 0이거나 10보다 큽니다.");
    }
  }

  /**
   * 현재 저장 된 랜덤 크기 실제 원해는 배열의 크가가 맞는 지 체크
   * @param baseBalls 등록 된 랜덤 3개의 숮자 HashSet
   */
  void validateRandomBaseBallSize(HashSet<Integer> baseBalls) {
    if (baseBalls.size() != COLLECTION_NUMBER_SIZE) {
      throw new IllegalArgumentException("랜덤으로 추출 된 크기가 3이 아닙니다.");
    }
  }

  /**
   * 중복 없는 랜덤 3개의 숫자(볼) 생성하기
   * @return 중복 없는 랜덤 3개의 숫자 HashSet
   */
  private HashSet<Integer> createRandomBaseBalls() {
    HashSet<Integer> baseBalls = new HashSet<>();
    Random random = new Random();

    while (isRandomBallSize(baseBalls)) {
      int choiceNumber = random.nextInt(MAX_NUMBER) + ZERO_NUMBER_EXCEPT;
      baseBalls.add(choiceNumber);
    }

    validateRandomNumberMax(baseBalls);
    validateRandomBaseBallSize(baseBalls);

    return baseBalls;
  }

  /**
   * 랜덤 숫자(볼) 크기 체크
   * @param randomBalls 현재 등록 된 랜덤 숫자(볼) Collection
   * @return 랜덤 숫자(볼) 크기 체크 결과 값
   */
  private boolean isRandomBallSize(HashSet<Integer> randomBalls) {
    return randomBalls.size() != COLLECTION_NUMBER_SIZE;
  }

}
