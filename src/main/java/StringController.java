import java.util.Arrays;

public class StringController {
    public static String chopAt(String in, int index) {
        in.charAt(index);      /* index range check */
        if(index == 0) {
            return in.substring(1, in.length());
        }
        if(index == in.length()-1) {
            return in.substring(0, in.length()-1);
        }
        return in.substring(0, index) + in.substring(index+1, in.length());
    }

    public static boolean hasDuplicatedChar(String in){
        if(in.length() < 2) {
            return false;
        }

        char[] chars = in.toCharArray();
        Arrays.sort(chars);
        boolean flag = false;
        for(int i=0; i<chars.length-1; i++){
            flag |= (chars[i] == chars[i+1]);
        }
        return flag;
    }
}
