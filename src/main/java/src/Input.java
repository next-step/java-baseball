import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Input {

    ArrayList inputData = new ArrayList();
    String output ;
    public void InputNumData() {
        Scanner input = new Scanner(System.in);
        int num ;
        num = input.nextInt();
        int first = (int)num/100;
        int mid = (int)(num%100)/10;
        int end = (int)(num%100)%10;

        this.inputData.add(Integer.toString(first));
        this.inputData.add(Integer.toString(mid));
        this.inputData.add(Integer.toString(end));
    }
    public ArrayList getInputNumList() {
        return this.inputData;
    }

    public String outputPrint(){
        return this.output;
    }

    public void inputData() { }
}
