public class Baseball {
    final private static int INPUT_LENGTH = 3;
    public static boolean isValidInput(String in) {
        if(!in.matches("^[0-9]+$")) {
            return false;
        }
        if(in.length() != Baseball.INPUT_LENGTH) {
            return false;
        }
        return true;
    }
}
