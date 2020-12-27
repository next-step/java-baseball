import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputReader {
    public static int getNumberInput(){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception e){
            return -1;
        }
    }
}
