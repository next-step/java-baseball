package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CommandLinePresentatorTest {

    @Test
    public void 숫자를_입력_받으면_그대로_리턴한다(){
        String str = "123";
        ByteArrayInputStream stringInputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(stringInputStream);

        Presentator presentator = new CommandLinePresentator();

        String s = presentator.presentInputNumber();

        assertEquals(str, s);
    }


}