package baseball;

import java.util.HashSet;

public class ContainsChecker {

	public static boolean isContains(int[] arr, int key) {		
		HashSet<Integer> differentSet = new HashSet<Integer>();		
		for (int i = 0; i < arr.length; i++) {
			differentSet.add(arr[i]);
		}		
		int initialSize = differentSet.size();
		differentSet.add(key);
		return differentSet.size() == initialSize;
	}

}
