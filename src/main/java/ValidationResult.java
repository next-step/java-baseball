public class ValidationResult {
    String message = "";
    int[] pitches = new int[3];
    boolean result = false;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int[] getPitches() {
        return pitches;
    }

    public void setPitches(int[] pitches) {
        this.pitches = pitches;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
