public class StringStudy {
    private String input;
    private String[] output;

    StringStudy(){}

    StringStudy(String input){
        this.input = input;
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

    public String substringPreEnd(String input){
        int pre = input.indexOf('(');
        String preString = pre > -1 ? input.substring(pre+1) : input;
        int end = preString.indexOf(')');
        return  end > -1 ? preString.substring(0,end) : preString;
    }

    public Character charAtABC(String input, int index){
        if(index > input.length()-1){
            throw new IndexOutOfBoundsException("index는 2까지 입력 가능합니다.");
        }
        return input.charAt(index);
    }

    public static void main(String[] args){
        StringStudy stringStudy = new StringStudy("(1,2)");
        System.out.println(stringStudy.substringPreEnd(stringStudy.getInput()));
    }

}
