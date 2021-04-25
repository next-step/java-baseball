package support;

public class ConvertUtils {
    public static int[] convertIntToArray(int intNumber) {

        String stringNumber = Integer.toString(intNumber);
        int len = stringNumber.length();
        int[] arr = new int[len];

        for (int i=0; i < len; i++) {
            arr[i] = Integer.parseInt(String.valueOf(stringNumber.charAt(i)));
        }

        return arr;
    }

    public static int convertArrayToInt(int[] arrayNumber) {
        StringBuilder sb = new StringBuilder();

        for (int i : arrayNumber) {
            sb.append(i);
        }

        return Integer.parseInt(sb.toString());
    }
}
