public class Result {

    public boolean isStrike(String inputVal, String target, int index) {
        char oneInputVal = inputVal.charAt(index);
        char oneTargetVal = target.charAt(index);

        if ( oneInputVal == oneTargetVal) {
            return true;
        }

        return false;
    }

    public boolean isBall(String inputVal, String target, int index) {
        char oneInputVal = inputVal.charAt(index);
        char oneTargetVal = target.charAt(index);

        if (oneInputVal != oneTargetVal && target.contains(Character.toString(oneInputVal))) {
            return true;
        }

        return false;
    }

}