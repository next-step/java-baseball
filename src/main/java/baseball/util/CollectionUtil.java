package baseball.util;

import java.util.Collection;

public final class CollectionUtil {

  private CollectionUtil() {
  }

  public static String joining(Collection<String> collection, String joinStr) {
    StringBuilder sb = new StringBuilder();
    for (String str : collection) {
      sb.append(str).append(joinStr);
    }
    return sb.length() == 0 ? sb.toString()
            : sb.substring(0, sb.length() - joinStr.length());
  }
}
