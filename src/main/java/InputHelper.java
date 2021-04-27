import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {
    private static final String EMPTY_STRING = "";

    private final BufferedReader br;

    public InputHelper() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String input() {
        try {
            return br.readLine();
        } catch (Exception e) {
            return EMPTY_STRING;
        }
    }

    public void destroy() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
