import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameOutputTest {

    GameOutput gameOutput;
    @BeforeEach
    void prepare() {
        gameOutput =GameOutput.getInstance();
    }

    @Test
    @DisplayName("입력하는 값이 정상 출력되는지 확인한다.")
    void writeMessage_shouldWriteMessage(){
        gameOutput.writeMessage("hello","this","is","test");
    }

    @Test
    @DisplayName("입력하는 값이 정상으로 한줄 출력되는지 확인한다.")
    void writeMessageInline_shouldWriteMessageInline(){
        gameOutput.writeMessageInline("hello","this","is","test");
        gameOutput.writeMessageInline("inline","test");
        gameOutput.writeFlush();
    }

}
