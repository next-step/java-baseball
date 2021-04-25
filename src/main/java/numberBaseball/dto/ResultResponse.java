package numberBaseball.dto;

public class ResultResponse {
    private boolean isClear;
    private String result;

    public boolean isClear() {
        return isClear;
    }

    public void setIsClear(boolean clear) {
        isClear = clear;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
