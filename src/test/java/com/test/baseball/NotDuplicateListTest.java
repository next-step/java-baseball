package com.test.baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotDuplicateListTest {
    @Test
    public void testAddNotDuplicate(){
        List<Integer> list = new NotDuplicateList();

        list.add(1);
        list.add(1);

        assertThat(list.size()).isEqualTo(1);
    }
}
