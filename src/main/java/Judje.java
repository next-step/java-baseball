import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Judje {
    public int strike;
    public int ball;

    public String toString() {
        if ((strike == 0) && (ball == 0)) return StringEncoder.GetUTF8String("낫싱");
        if (strike == 0) return StringEncoder.GetUTF8String(ball + "볼");
        if (ball == 0) return StringEncoder.GetUTF8String(strike + " 스트라이크");
        return StringEncoder.GetUTF8String(strike + " 스트라이크" + ball + "볼");
    }

    public Judje() {
        this.strike = 0;
        this.ball = 0;
    }
}
