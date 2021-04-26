package baseball.util;

import java.util.ArrayList;
import java.util.List;

public final class StringUtil {
  private StringUtil() {
  }

  public static List<Integer> toIntegerList(String str) {
    List<Integer> result = new ArrayList<>();
    for (String test : split(str)) {
      result.add(Integer.parseInt(test));
    }
    return result;
  }

  public static String[] split(String str) {
    if (isBlank(str)) {
      return new String[]{};
    }
    return defaultString(str).split("");
  }

  public static String defaultString(String str) {
    if (isBlank(str)) {
      return "";
    }
    return str;
  }

  public static boolean isBlank(String str) {
    return str == null || str.isEmpty();
  }
}
