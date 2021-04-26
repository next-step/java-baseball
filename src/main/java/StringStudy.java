public class StringStudy {
    private String input;
    private String[] output;

    StringStudy(){}

    StringStudy(String inputString){
        this.input = inputString;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public String[] getOutput() {
        return output;
    }

    public void setOutput(String[] output) {
        this.output = output;
    }

    public String[] seperateOneTwo(String input){
        return input.split(",");
    }


}
