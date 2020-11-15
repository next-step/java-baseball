package com.test.baseball;

import java.util.ArrayList;

public class NotDuplicateList extends ArrayList<Integer> {
    @Override
    public boolean add(Integer item){
        if (super.contains(item)) {
            return false;
        }
        return super.add(item);
    }
}
