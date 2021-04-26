package numberbaseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PitchingFactory {

  private static final int FIRST_INDEX = 0;
  private static final List<Pitching> PITCHING_POOL = new ArrayList<>();

  static {
    for(int pitching = Pitching.MIN ; pitching <= Pitching.MAX ; pitching++) {
      PITCHING_POOL.add(new Pitching(pitching));
    }
  }

  private PitchingFactory() {}

  public static List<Pitching> generateGivenCountPitching(int given) {
    Collections.shuffle(PITCHING_POOL);
    return PITCHING_POOL.subList(FIRST_INDEX, given);
  }


}
