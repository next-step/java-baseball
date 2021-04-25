package numberbaseball.domain;


import java.util.*;

public class Inning {

  private static final int PITCHING_COUNT_PER_INNING = 3;
  private static final String PLEASE_INPUT_N_DIGITS_INTEGER = "%d 자리 수를 입력해주세요.";
  private static final String PLEASE_INPUT_DIFFERENT_PITCHING_EACH_OTHER = "각 자리수가 서로 다르게 입력해주세요.";

  private final Map<Pitching, Integer> pitchingAndOrder;

  public Inning(List<Pitching> pitchingCollection) {
    throwExceptionIfNotValidPitchingCount(pitchingCollection);
    this.pitchingAndOrder = transformToPitchingAndOrderMap(pitchingCollection);
  }

  public static Inning generateRandomInning() {
    return new Inning(PitchingFactory.generateGivenCountPitching(PITCHING_COUNT_PER_INNING));
  }

  private Map<Pitching, Integer> transformToPitchingAndOrderMap(List<Pitching> pitchingCollection) {
    Map<Pitching, Integer> pitchingAndOrderMap = new HashMap<>();
    int pitchingCollectionSize = pitchingCollection.size();
    for(int index = 0; index < pitchingCollectionSize; index++) {
      Pitching pitching = pitchingCollection.get(index);
      throwExceptionIfDuplicatePitching(pitchingAndOrderMap, pitching);
      pitchingAndOrderMap.put(pitching, index);
    }
    return pitchingAndOrderMap;
  }

  private void throwExceptionIfDuplicatePitching(Map<Pitching, Integer> pitchingAndOrder, Pitching pitching) {
    if(pitchingAndOrder.containsKey(pitching)) {
      throw new IllegalArgumentException(PLEASE_INPUT_DIFFERENT_PITCHING_EACH_OTHER);
    }
  }

  private void throwExceptionIfNotValidPitchingCount(List<Pitching> pitchingCollection) {
    if(pitchingCollection.size() != PITCHING_COUNT_PER_INNING) {
      throw new IllegalArgumentException(String.format(PLEASE_INPUT_N_DIGITS_INTEGER, PITCHING_COUNT_PER_INNING));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Inning inning = (Inning) o;
    return pitchingAndOrder.equals(inning.pitchingAndOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pitchingAndOrder);
  }
}
