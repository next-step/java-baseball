package numberbaseball.domain;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Inning {

  private static final int PITCHING_COUNT_PER_INNING = 3;

  private final List<Pitching> pitchingCollection;

  public Inning(List<Pitching> pitchingCollection) {
    validatePitchingCollection(pitchingCollection);
    this.pitchingCollection = pitchingCollection;
  }

  private void validatePitchingCollection(List<Pitching> pitchingCollection) {
    throwExceptionIfNotValidPitchingCount(pitchingCollection);

    Set<Pitching> sameNumberFilter = new HashSet<>();
    for(Pitching pitching : pitchingCollection) {
      throwExceptionIfDuplicated(sameNumberFilter, pitching);
    }
  }

  private void throwExceptionIfNotValidPitchingCount(List<Pitching> pitchingCollection) {
    if(pitchingCollection.size() != PITCHING_COUNT_PER_INNING) {
      throw new IllegalArgumentException("");
    }
  }

  private void throwExceptionIfDuplicated(Set<Pitching> sameNumberFilter, Pitching number) {
    if(!sameNumberFilter.add(number)) {
      throw new IllegalArgumentException("");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Inning inning = (Inning) o;
    return pitchingCollection.equals(inning.pitchingCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pitchingCollection);
  }
}
