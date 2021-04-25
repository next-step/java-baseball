package generator;

public class NumGenerator {
    public static String numGenerator(int figure, int min, int max){
        String numStr = "";
        int[] num = new int[figure];
        for(int i=0 ; i<figure ; i++){
            num[i] = (int)(Math.random()*(max - min + 1)) + 1;
            //numStr += Integer.toString(num[i]);
            numStr = numStr.concat(Integer.toString(num[i]));
        }
        return numStr;
    }
}
