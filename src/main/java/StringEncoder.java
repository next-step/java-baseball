import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class StringEncoder {
    public static String GetUTF8String(String statement) {
        return new String(statement.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
}
