package com.test.baseball;

import java.util.ArrayList;

public class NotDuplicateList extends ArrayList<Integer> {
    private int maxSize;

    public NotDuplicateList(){}

    public NotDuplicateList(int maxSize){
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(Integer item){
        if (super.contains(item)) {
            return false;
        }
        return super.add(item);
    }

    public boolean isFull(){
        return maxSize == super.size();
    }
}
