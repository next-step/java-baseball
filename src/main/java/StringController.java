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
}
