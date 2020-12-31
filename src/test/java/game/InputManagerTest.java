package game;

import org.junit.jupiter.api.Test;
import validators.Validator;

import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {
    @Test
    public void test(){
        InputManager im = new InputManager();
        String an = im.receiveInput("안 이라고 입력해주세요", new Validator() {
            @Override
            public void checkValid(String input) throws Exception {
                if(!"안".equals(input))
                    throw new Exception("안이 아닌데요?");
            }
        });
        assertTrue(an.equals("안"));
    }
}