package game;

import game.Answer;
import org.assertj.core.util.introspection.FieldUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    Answer answer;
    @BeforeEach
    public void before(){
        answer = new Answer();
    }

    @Test
    public void testCorrect(){
        String ans = answer.answer;
        assertTrue(answer.isCorrect(ans));
    }
    @Test
    public void testNonCorrect(){
        String ans = answer.answer;
        int[] nums = new int[10];
        for (int i = 0; i < ans.length(); i++) {
            nums[ans.charAt(i) - '0'] = 1;
        }
        String notAns = "";
        int count = 0;
        for (int i = 0; i < 10 && count < 3; i++) {
            if(nums[i] == 0) {
                notAns += i;
                count++;
            }
        }
        assertFalse(answer.isCorrect(notAns));
    }
}