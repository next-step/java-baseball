package baseball.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

  public static <T> List<T> distinctList(List<T> list) {
    List<T> distinctList = new ArrayList<>();
    for (T t : list) {
      if (distinctList.contains(t)) {
        continue;
      }

      distinctList.add(t);
    }
    return distinctList;
  }

  public static <T> boolean isEmpty(Collection<T> collection) {
    return collection == null || collection.isEmpty();
  }
}
