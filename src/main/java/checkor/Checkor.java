package checkor;

public interface Checkor<T> {

    T check(String input);

    default int[] stringToIntArr(String input) {
        int[] result = new int[input.length()];
        char[] charArray = input.toCharArray();
        for (int i=0; i<charArray.length; i++) {
            result[i] = charArray[i]-'0';
        }
        return result;
    }
}
