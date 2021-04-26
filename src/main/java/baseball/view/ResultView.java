package baseball.view;

import baseball.domain.BallRecord;
import baseball.domain.StrikeZone;
import baseball.util.CollectionUtil;
import baseball.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class ResultView {
  private static final String ALL_MISS_TYPE_NAME = "낫싱";
  private static final String JOINING_SEPARATOR = ", ";
  private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

  private ResultView() {
  }

  public static void print(BallRecord record) {
    String result = CollectionUtil.joining(getRecordStrings(record), JOINING_SEPARATOR);
    System.out.println(StringUtil.defaultString(result, ALL_MISS_TYPE_NAME));

    if (record.isStrikeOut()) {
      System.out.println(GAME_OVER_MESSAGE);
    }
  }

  private static List<String> getRecordStrings(BallRecord record) {
    List<String> list = new ArrayList<>();
    Set<StrikeZone> strikeZones = record.getValues().keySet();
    for (StrikeZone strikeZone : strikeZones) {
      if (strikeZone == StrikeZone.MISS) {
        continue;
      }
      list.add(getStrikeZoneToString(record, strikeZone));
    }

    return list;
  }

  public static String getStrikeZoneToString(BallRecord record, StrikeZone strikeZone) {
    return String.format("%d %s", record.getCount(strikeZone), strikeZone.getName());
  }
}
