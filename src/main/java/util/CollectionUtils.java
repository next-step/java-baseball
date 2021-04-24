package util;

import java.util.Collection;

public final class CollectionUtils {

	private CollectionUtils() {
	}

	public static boolean isEmpty(Collection<?> collections) {
		if (collections == null) {
			return true;
		}

		return collections.isEmpty();
	}
}
